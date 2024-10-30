/**
 * Clase que representa la interfaz de artículo. 
 * @author David Chacón <jhoanchacon@unicauca.edu.co>
 * @author Jonathan Guejia <jonathanguejia@unicauca.edu.co>
 * @version 1.0
 * @since 2024
 */

package co.edu.unicauca.api_rest_article.fachadaServices.services;

import java.util.List;

import co.edu.unicauca.api_rest_article.fachadaServices.DTO.ArticlesWithConferencesDTO.ArticleWithConferencesDTO;
import co.edu.unicauca.api_rest_article.fachadaServices.DTO.ArticlesWithConferencesDTO.ConferenceDTO;
import co.edu.unicauca.api_rest_article.fachadaServices.DTO.CRUDArticleDTO.ArticleDTO;



public interface IArticleService {

	/**
     * Recupera todos los artículos DTO registrados
     * @return
     */
    public List<ArticleDTO> findAll();

	/**
     * Recupera un artículo DTO específico
     * @param id id del artículo
     * @return
     */
	public ArticleDTO findById(Integer id);

	/**
     * Almacena un artículo DTO
     * @param art artículo
     * @return
     */
	public ArticleDTO save(ArticleDTO articulo);

	/**
     * Permite actualizar un artículo DTO
     * @param id id del artículo
     * @param newArticle nuevo artículo
     * @return
     */
	public ArticleDTO update(Integer id, ArticleDTO articulo);

	/**
     * Permite borrar un artículo
     * @param id id del artículo
     * @return
     */
	public boolean delete(Integer id);

	/**
     * Verifica si existe un artículo
     * @param id id del artículo
     * @return
     */
    public boolean exists(int id);

	/**
     * Permite obtener las conferencias DTO a las cuales esta registrado un artículo (Comunicación sincrona)
     * @param idArticle
     * @return
     */
	public List<ConferenceDTO> getConferencesByArticle(Integer idArticle);

	/**
     * Permite obtener artículos con conferencias DTO 
     * @param idArticle
     * @return
     */
	public ArticleWithConferencesDTO getArticleWithConferences(Integer idArticle);
} 


