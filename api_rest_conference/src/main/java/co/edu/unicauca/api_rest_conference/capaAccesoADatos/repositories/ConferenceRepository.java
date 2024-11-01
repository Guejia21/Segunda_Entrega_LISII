/**
 * Clase que representa el repostiorio de conferencias.
 * @author David Chacón <jhoanchacon@unicauca.edu.co>
 * @author Jonathan Guejia <jonathanguejia@unicauca.edu.co>
 * @version 1.0
 * @since 2024
 */

package co.edu.unicauca.api_rest_conference.capaAccesoADatos.repositories;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.api_rest_conference.capaAccesoADatos.models.ArticleEntity;
import co.edu.unicauca.api_rest_conference.capaAccesoADatos.models.ConferenceEntity;

@Repository
public class ConferenceRepository {
    private ArrayList<ConferenceEntity> listConferences; //Aqui se almacenaran las conferencias
    private AtomicInteger idIterator;

    public ConferenceRepository(){
        this.listConferences = new ArrayList<ConferenceEntity>();
        loadConferences();
        idIterator = new AtomicInteger(listConferences.size());
    }

    /**
     * Permite listar todas las conferencias almacenadas
     * @return
     */
    public ArrayList<ConferenceEntity> findAll(){ 
        System.out.println("Getting all the conferences");
        return this.listConferences;
    }

    /**
     * Recupera una conferencia específica
     * @param id id de conferencia
     * @return
     */
    public ConferenceEntity findById(int id){
        System.out.println("Looking for a conference");
        ConferenceEntity conference = null;
        for(ConferenceEntity conf : listConferences){
            if(conf.getId()==id){
                conference = conf;
                break;
            }
        }
        return conference;
    }

    /**
     * Almacena una nueva conferencia
     * @param conf nueva conferencia
     * @return
     */
    public ConferenceEntity save(ConferenceEntity conf){
        System.out.println("Saving a conference");
        conf.setId(idIterator.incrementAndGet());
        ConferenceEntity conference = null;
        if(listConferences.add(conf)){
            conference = conf;
        }
        return conference;

    }

    /**
     * Actualiza una conferencia existente
     * @param id id de conferencia a actualizar
     * @param newConference nueva conferencia
     * @return
     */
    public ConferenceEntity update(int id, ConferenceEntity newConference){
        System.out.println("Updating a conference");
        ConferenceEntity oldConference = findById(id);
        if(oldConference!=null){
            newConference.setId(solveId(id,newConference.getId()));
            int index = findIndex(id);
            listConferences.set(index, newConference);
            return newConference;
        }
        return null;
    }

    /**
     * Retorna el número de artículos asociados a una conferencia
     * @param id id de conferencia
     * @return
     */
    public int countArticlesInConference(int id){
        System.out.println("Counting articles in a conference");
        ConferenceEntity conference = findById(id);
        return conference.getArticulos().size();
    }
  
    /**
     * Recupera el índice de una conferencia
     * @param id id a buscar
     * @return
     */
    private int findIndex(int id) {
        for(int i = 0; i < listConferences.size();i++){
            if(listConferences.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }

    /**
     * Permite asegurar que el id nuevo sea único dentro de la lista de conferencias
     * @param id id Conferencia
     * @param newId id nuevo de conferencia
     * @return
     */
    private int solveId(int id, int newId){
        if(id==newId){
            return id;
        }
        for(ConferenceEntity conf : listConferences){
            if(conf.getId()==newId){
                return solveId(id,newId+1);
            }
        }
        return newId;
    }
    
    /**
     * Crear conferencias de prueba
     */
    private void loadConferences(){
        List<ArticleEntity> articles1 = new ArrayList<ArticleEntity>();
        List<ArticleEntity> articles2 = new ArrayList<ArticleEntity>();
        ArticleEntity a1 = new ArticleEntity();
        a1.setId(10);
        ArticleEntity a2 = new ArticleEntity();
        a2.setId(11);
        ArticleEntity a3 = new ArticleEntity();
        a3.setId(12);
        articles1.add(a1);   
        articles1.add(a2); 

        articles2.add(a3);
        
        // Creación de la primera conferencia
        ConferenceEntity conference1 = new ConferenceEntity();
            conference1.setId(1);
            conference1.setNombre("Conferencia Internacional de Tecnología");
            conference1.setFechaInicio(new Date());
            conference1.setFechaFin(new Date());
            conference1.setCantidadMaxArticulos(100);
            conference1.setCostoInscripcion(200.0f);
            conference1.setArticulos(articles1);

        ConferenceEntity conference2 = new ConferenceEntity();
            conference2.setId(2);
            conference2.setNombre("Tecnología");
            conference2.setFechaInicio(new Date());
            conference2.setFechaFin(new Date());
            conference2.setCantidadMaxArticulos(50);
            conference2.setCostoInscripcion(200.0f);
            conference2.setArticulos(articles2);

        this.listConferences.add(conference1);
        this.listConferences.add(conference2);
        
    }

    /**
     * Permite borrar una conferencia
     * @param id id de conferencia
     * @return
     */
    public boolean delete(Integer id) {
        System.out.println("Deleting a conference");
        boolean bandera=false;
        int index = findIndex(id);
        if(index != -1) {
            listConferences.remove(index);
            return true;
        }
        return bandera;
    }

    /**
     * Permite saber si existe una conferencia con un id
     * @param id id de conferencia
     * @return
     */
    public boolean exists(int id) {
        System.out.println("Checking if a conference exists");
        ConferenceEntity conference = findById(id);
        return conference!=null;
    }

    /**
     * Obtiene conferencias en las cuales esta registrado un artículo
     * @param idArticle
     * @return
     */
    public List<ConferenceEntity> getConferencesByArticle(int idArticle) {
        System.out.println("Getting conferences by article");
        List<ConferenceEntity> conferences = new ArrayList<ConferenceEntity>();
        for(ConferenceEntity conf : listConferences){
            if(conf.getArticulos()!=null){
                for(ArticleEntity article : conf.getArticulos()){
                    if(article.getId()==idArticle){
                        conferences.add(conf);
                        break;
                    }
                }
            }
        }
        System.out.println("Returning conferences by article, cuantity: "+conferences.size());
        return conferences;
    }
}
