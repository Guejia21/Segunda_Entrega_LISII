/**
 * Interfaz de conferenci.
 * @author David Chacón <jhoanchacon@unicauca.edu.co>
 * @author Jonathan Guejia <jonathanguejia@unicauca.edu.co>
 * @version 1.0
 * @since 2024
 */

package co.edu.unicauca.api_rest_conference.fachadaServices.services;

import java.util.List;

import co.edu.unicauca.api_rest_conference.fachadaServices.DTO.ConferenceDTO;

public interface IConferenceService {

	/**
	 * Permite listar todas las conferencias almacenadas
	 * @return
	 */	
    public List<ConferenceDTO> findAll();

	/**
	 * Permite encontrar una conferencia específica
	 * @param id id de conferencia
	 * @return
	 */
	public ConferenceDTO findById(Integer id);

	/**
	 * Permite almacenar una conferencia nueva
	 * @param conferencia nueva conferencia
	 * @return
	 */
	public ConferenceDTO save(ConferenceDTO conferencia);

	/**
	 * Permite actualizar una conferencia
	 * @param id id de conferencia
	 * @param conferencia conferencia actulizada
	 * @return
	 */
	public ConferenceDTO update(Integer id, ConferenceDTO conferencia);

	/**
	 * Permite contar la cantidad de artículos asociados a una conferencia
	 * @param id id de conferencia
	 * @return
	 */
	public int countArticlesInConference(Integer id);

	/**
	 * Permite borrar una conferencia
	 * @param id id de conferencia
	 * @return
	 */
	public boolean delete(Integer id);

	/**
	 * Permite verificar si existe una conferencia
	 * @param id id de conferencia
	 * @return
	 */
    public boolean exists(int id);

	/**
	 * Permite obtener las conferencias a la cuales esta registrado un artículo
	 * @param idArticle
	 * @return
	 */
	public List<ConferenceDTO> getConferencesByArticle(int idArticle);
}
