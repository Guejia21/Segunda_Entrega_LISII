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
    //El primer servicio recibe un artículo a registrar y retorna el articulo registrado
    @PostMapping("/articles")
	public ArticleDTO createArticle(@RequestBody ArticleDTO Article) {
		ArticleDTO objArticle = articleService.save(Article);
		return objArticle;
	}
    //El segundo servicio REST recibe el IDdel articulo y retorna el artículo que corresponde con el ID.
    @GetMapping("/articles/{id}")
    public ArticleDTO getArticleById(@PathVariable Integer id) {
        ArticleDTO art = articleService.findById(id);
        return art;
    }
    //El tercer servicio REST no recibe datos y retorna una lista de Los artículosregistrados
    @GetMapping("/articles/list")
    public List<ArticleDTO> listArticles() {
        return articleService.findAll();
    }
    //El cuarto servicio REST recibe el ID dl artículo a actualizar y los nuevos datos del artículo , y retorna el
    //artículo actualizado
    @PutMapping("/articles/{id}")
    public ArticleDTO updateArticle(@PathVariable Integer id, @RequestBody ArticleDTO newArticle) {
        ArticleDTO oldArtice = articleService.findById(id);
        ArticleDTO updatedArticle = null;
        if(oldArtice!=null){
            updatedArticle = articleService.update(id, newArticle);
        }
        return updatedArticle;
    }
    //El quinto servicio REST recibe el ID del articulo a eliminar y retorna true o false si se eliminó. Utilice
    //pathVariable
    @DeleteMapping("/articles/{id}")
    public boolean deleteArticle(@PathVariable Integer id){
        boolean bandera = false;
        ArticleDTO art = articleService.findById(id);
        if(art!=null) bandera = articleService.delete(id);
        return bandera;
    }
    // El sexto servicio REST recibe el ID del articulo a consultar y retorna true o false si existe. Para el último
    //servicio utilice una URL diferente al segundo servicio con el fin de evitar conflictos. Utilice RequestParam.
    @GetMapping("/articles/exists")
    public boolean verifyExistenceArticle(@RequestParam Integer id) {
        return articleService.exists(id);
    }
    //El séptimo servicio REST recibe el ID del artículo y retorna la lista de conferencias 
    //donde está inscrito el artículo.
    @GetMapping("/articles/conferences/{idArticle}")
    public List<ConferenceDTO> getConferencesByArticle(@PathVariable Integer idArticle) {
        return articleService.getConferencesByArticle(idArticle);
    }
    //El octavo servicio REST recibe el ID del artículo y retorna el artículo con la lista de 
    //conferencias donde está inscrito.
    @GetMapping("/articles/articleWithConferences/{idArticle}")
    public ArticleWithConferencesDTO getArticleWithConferences(@PathVariable Integer idArticle) {
        return articleService.getArticleWithConferences(idArticle);
    }
    
    
}