package co.edu.unicauca.api_rest_article.fachadaServices.services;

import java.util.List;

import co.edu.unicauca.api_rest_article.fachadaServices.DTO.ArticlesWithConferencesDTO.ArticleWithConferencesDTO;
import co.edu.unicauca.api_rest_article.fachadaServices.DTO.ArticlesWithConferencesDTO.ConferenceDTO;
import co.edu.unicauca.api_rest_article.fachadaServices.DTO.CRUDArticleDTO.ArticleDTO;



public interface IArticleService {

    public List<ArticleDTO> findAll();

	public ArticleDTO findById(Integer id);

	public ArticleDTO save(ArticleDTO articulo);

	public ArticleDTO update(Integer id, ArticleDTO articulo);

	public boolean delete(Integer id);

    public boolean exists(int id);

	public List<ConferenceDTO> getConferencesByArticle(Integer idArticle);

	public ArticleWithConferencesDTO getArticleWithConferences(Integer idArticle);
    
} 


