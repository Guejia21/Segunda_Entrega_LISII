/**
 * Clase que representa el repositorio de la clase artículo. 
 * @author David Chacón <jhoanchacon@unicauca.edu.co>
 * @author Jonathan Guejia <jonathanguejia@unicauca.edu.co>
 * @version 1.0
 * @since 2024
 */
package co.edu.unicauca.api_rest_article.capaAccesoADatos.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.api_rest_article.capaAccesoADatos.models.ArticleEntity;


@Repository
public class ArticleRepository {
    private ArrayList<ArticleEntity> listArticles; //Aqui se almacenaran los articulos
    private AtomicInteger idIterator;

    public ArticleRepository(){
        this.listArticles = new ArrayList<ArticleEntity>();
        loadArticles();
        idIterator = new AtomicInteger(listArticles.size());
    }

    /**
     * Recupera todos los artículos registrados
     * @return
     */
    public List<ArticleEntity> findAll(){ 
        System.out.println("Getting all the articles");
        return this.listArticles;
    }

    /**
     * Recupera un artículo específico
     * @param id id del artículo
     * @return
     */
    public ArticleEntity findById(int id){
        System.out.println("Looking for an article");
        ArticleEntity article = null;
        for(ArticleEntity art : listArticles){
            if(art.getId()==id){
                article = art;
                break;
            }
        }
        return article;
    }

    /**
     * Almacena un artículo
     * @param art artículo
     * @return
     */
    public ArticleEntity save(ArticleEntity art){
        System.out.println("Saving an article");
        art.setId(idIterator.incrementAndGet());
        ArticleEntity article = null;
        if(listArticles.add(art)){
            article = art;
        }
        System.out.println("Article saved: "+ article.getNombre());
        System.out.println("Prueba de como llegan los autores: " + article.getAutores());
        return article;
    }

    /**
     * Permite actualizar un artículo
     * @param id id del artículo
     * @param newArticle nuevo artículo
     * @return
     */
    public ArticleEntity update(int id, ArticleEntity newArticle){
        System.out.println("Updating an article");
        ArticleEntity oldArticle = findById(id);
        if(oldArticle!=null){
            newArticle.setId(solveId(id,newArticle.getId()));
            int index = findIndex(id);
            listArticles.set(index, newArticle);
            return newArticle;
        }
        return null;
    }
    
    /**
     * Encuentra el indice de un artículo en la lista
     * @param id id del artículo
     * @return
     */
    private int findIndex(int id) {
        for(int i = 0; i < listArticles.size();i++){
            if(listArticles.get(i).getId()==id) return i;
        }
        return -1;
    }
    
    /**
     * Método que previene que se actualice el id de un artículo, por un id ya existente
     * @param oldId id antiguo
     * @param newId id nuevo
     * @return
     */
    private int solveId(int oldId, int newId) {
        //Si es 0 significa que no se asigno un nuevo id
        //Si ya existe un articulo con ese id, se deja el id original
        if(newId == 0 || newId == oldId || exists(newId)) {
            System.out.println("The new id already exits, old id will be conserved");
            return oldId; 
        }
        else{
            return newId;    
        } 
    }

    /**
     * Permite borrar un artículo
     * @param id id del artículo
     * @return
     */
    public boolean delete(Integer id) {
		System.out.println("Deleting an article");
		boolean bandera=false;
        int index = findIndex(id);
        if(index != -1) {
            listArticles.remove(index);
            bandera = true;
        }
		return bandera;
	}

    /**
     * Permite verificar la existencia de un artículo
     * @param id id del artículo
     * @return
     */
    public boolean exists(int id){
        System.out.println("Verifing if an arcticle exists");
        ArticleEntity art = findById(id);
        if(art != null) return true;
        return false;
    }
    
    /**
     * Cargar artículos de prueba
     */
    private void loadArticles() {
        ArticleEntity a1 = new ArticleEntity(10, "articulo1", "David Chacon, Jonathan Guejia", 2, "revista1");
        ArticleEntity a2 = new ArticleEntity(11, "articulo2", "Jorge Martinez", 1, "revista2");
        ArticleEntity a3 = new ArticleEntity(12, "articulo3", "Jonathan Guejia", 1, "revista3");
        this.listArticles.add(a1);
        this.listArticles.add(a2);
        this.listArticles.add(a3);
    }
}
