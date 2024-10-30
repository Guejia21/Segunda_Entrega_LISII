/**
 * Clase que representa la definición de los servicios REST.
 * @author David Chacón <jhoanchacon@unicauca.edu.co>
 * @author Jonathan Guejia <jonathanguejia@unicauca.edu.co>
 * @version 1.0
 * @since 2024
 */

package co.edu.unicauca.api_rest_conference.capaControladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.api_rest_conference.fachadaServices.DTO.ConferenceDTO;
import co.edu.unicauca.api_rest_conference.fachadaServices.services.IConferenceService;

@RestController
@RequestMapping("/api")
public class ConferenceRestController {
    //Aqui se inyecta la dependencia de la interfaz IConferenceService
    @Autowired
    private IConferenceService conferenceService;

    /**
     * Permite crear una nueva conferencia
     * @param conference nueva coferencia
     * @return
     */
    @PostMapping("/conferences")
	public ConferenceDTO createConference(@RequestBody ConferenceDTO conference) {
		ConferenceDTO objConference = conferenceService.save(conference);
		return objConference;
	}
    
    /**
     * Permite obtener una conferencia por su id
     * @param id id de conferencia
     * @return
     */
    @GetMapping("/conferences/{id}")
    public ConferenceDTO getConferenceById(@PathVariable Integer id) {
        ConferenceDTO conf = conferenceService.findById(id);
        return conf;
    }
    
    /**
     * Permite listar todas las conferencias almacenadas
     * @return
     */
    @GetMapping("/conferences/list")
    public List<ConferenceDTO> listConferences() {
        return conferenceService.findAll();
    }
    
    /**
     * Permite actualizar una conferencia
     * @param id id de conferencia
     * @param newConference nueva conferencia
     * @return
     */
    @PutMapping("/conferences/{id}")
    public ConferenceDTO updateConference(@PathVariable Integer id, @RequestBody ConferenceDTO newConference) {
        ConferenceDTO oldConference = conferenceService.findById(id);
        ConferenceDTO updatedConference = null;
        if(oldConference!=null){
            updatedConference = conferenceService.update(id, newConference);
        }
        return updatedConference;
    }
    
    /**
     * Permite obtener la cantidad de articulos de una conferencia
     * @param id id de conferencia
     * @return
     */
    @GetMapping("conferences/countArticles/{id}")
    public int countArticlesInConference(@PathVariable Integer id) {
        return this.conferenceService.countArticlesInConference(id);
    }
    
    /**
     * Permite borrar una conferencia
     * @param id id de conferencia
     * @return
     */
    @DeleteMapping("/conferences/{id}")
    public boolean deleteConference(@PathVariable Integer id){
        boolean bandera = false;
        ConferenceDTO conf = conferenceService.findById(id);
        if(conf!=null) bandera = conferenceService.delete(id);
        return bandera;
    }
    
    /**
     * Verifica la existencia de una conferencia
     * @param id id de una conferencia
     * @return
     */     
    @GetMapping("/conferences/exists")
    public boolean verifyExistenceConference(@RequestParam Integer id) {
        return conferenceService.exists(id);
    }

    /**
     * Permite obtener las conferencias a las cuales esta registrado un artículo (comunicación sícrona)
     * @param idArticle id del artículo
     * @return
     */
    @GetMapping("/conferences/article/{idArticle}")
    public List<ConferenceDTO> getConferencesByArticle(@PathVariable Integer idArticle) {
        System.out.println("Getting conferences by article with id: "+idArticle);
        return conferenceService.getConferencesByArticle(idArticle);
    }
    
    
}
