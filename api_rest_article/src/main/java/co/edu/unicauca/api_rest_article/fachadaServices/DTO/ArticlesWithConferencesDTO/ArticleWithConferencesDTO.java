/**
 * Clase que representa la clase DTO para un artículo con conferencias. 
 * @author David Chacón <jhoanchacon@unicauca.edu.co>
 * @author Jonathan Guejia <jonathanguejia@unicauca.edu.co>
 * @version 1.0
 * @since 2024
 */
package co.edu.unicauca.api_rest_article.fachadaServices.DTO.ArticlesWithConferencesDTO;

import java.util.List;

import co.edu.unicauca.api_rest_article.fachadaServices.DTO.CRUDArticleDTO.ArticleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticleWithConferencesDTO {
    private ArticleDTO article;
    private List<ConferenceDTO> conferences;
}
