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
    public List<ArticleEntity> findAll(){ //Recupera todos los articulos guardados
        System.out.println("Getting all the articles");
        return this.listArticles;
    }
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
    public ArticleEntity save(ArticleEntity art){
        System.out.println("Saving an article");
        art.setId(idIterator.incrementAndGet());
        ArticleEntity article = null;
        if(listArticles.add(art)){
            article = art;
        }
        return article;

    }
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
    //Este metodo encuentra el indice del articulo en la lista, puesto que el id no necesariamente
    //es el indice.
    private int findIndex(int id) {
        for(int i = 0; i < listArticles.size();i++){
            if(listArticles.get(i).getId()==id) return i;
        }
        return -1;
    }
    //Este metodo previene que el usuario actualize un articulo con un id ya existente
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
    public boolean exists(int id){
        System.out.println("Verifing if an arcticle exists");
        ArticleEntity art = findById(id);
        if(art != null) return true;
        return false;
    }
    private void loadArticles() {
        this.listArticles.add(new ArticleEntity(
            1,"Palabras Mayores",
            new String[]{"Carlos","Jose Candela"},2,"Nature"));
        this.listArticles.add(new ArticleEntity(
            2,"Palabras Menores",
            new String[]{"Carlos Candela","Temu Jose"},2,"Forbes"));
    }
}
