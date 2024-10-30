/**
 * Clase que representa la definición de los servicios REST. 
 * @author David Chacón <jhoanchacon@unicauca.edu.co>
 * @author Jonathan Guejia <jonathanguejia@unicauca.edu.co>
 * @version 1.0
 * @since 2024
 */

package co.edu.unicauca.api_rest_article.capaControladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.api_rest_article.fachadaServices.DTO.ArticlesWithConferencesDTO.ArticleWithConferencesDTO;
import co.edu.unicauca.api_rest_article.fachadaServices.DTO.ArticlesWithConferencesDTO.ConferenceDTO;
import co.edu.unicauca.api_rest_article.fachadaServices.DTO.CRUDArticleDTO.ArticleDTO;
import co.edu.unicauca.api_rest_article.fachadaServices.services.IArticleService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")
public  class ArticleRestController {
    @Autowired
    private IArticleService articleService;
    
    /**
     * Recibe un artículo en formato JSON, lo registra y retorna el artículo nuevo
     * @param Article artículo nuevo
     * @return
     */
    @PostMapping("/articles")
	public ArticleDTO createArticle(@RequestBody ArticleDTO Article) {
        System.out.println("Article: "+Article.getNombre());
		ArticleDTO objArticle = articleService.save(Article);
		return objArticle;
	}

    /**
     * Obtiene un artículo por su id
     * @param id id del artículo
     * @return
     */
    @GetMapping("/articles/{id}")
    public ArticleDTO getArticleById(@PathVariable Integer id) {
        ArticleDTO art = articleService.findById(id);
        return art;
    }

    /**
     * Obtiene todos los artículos guardados
     * @return
     */
    @GetMapping("/articles/list")
    public List<ArticleDTO> listArticles() {
        return articleService.findAll();
    }
   
    /**
     * Recibe un artículo para actualizarlo
     * @param id id del artículo
     * @param newArticle nuevo artículo
     * @return
     */
    @PutMapping("/articles/{id}")
    public ArticleDTO updateArticle(@PathVariable Integer id, @RequestBody ArticleDTO newArticle) {
        ArticleDTO oldArtice = articleService.findById(id);
        ArticleDTO updatedArticle = null;
        if(oldArtice!=null){
            updatedArticle = articleService.update(id, newArticle);
        }
        return updatedArticle;
    }

    /**
     * Permite eliminar un artículo
     * @param id id del artículo
     * @return
     */
    @DeleteMapping("/articles/{id}")
    public boolean deleteArticle(@PathVariable Integer id){
        boolean bandera = false;
        ArticleDTO art = articleService.findById(id);
        if(art!=null) bandera = articleService.delete(id);
        return bandera;
    }
    
    /**
     * Verifica si un artículo existe
     * @param id id del artículo
     * @return
     */
    @GetMapping("/articles/exists")
    public boolean verifyExistenceArticle(@RequestParam Integer id) {
        return articleService.exists(id);
    }
    
    /**
     * Permite obtener las conferencias a las cuales esta registrado un artículo (Comunicación sincrona)
     * @param idArticle
     * @return
     */
    @GetMapping("/articles/conferences/{idArticle}")
    public List<ConferenceDTO> getConferencesByArticle(@PathVariable Integer idArticle) {
        return articleService.getConferencesByArticle(idArticle);
    }
 
    /**
     * Permite obtener las conferencias a las cuales esta registrado un artículo con sus datos (Comunicación sincrona)
     * @param idArticle
     * @return
     */
    @GetMapping("/articles/articleWithConferences/{idArticle}")
    public ArticleWithConferencesDTO getArticleWithConferences(@PathVariable Integer idArticle) {
        return articleService.getArticleWithConferences(idArticle);
    }
    
    
}