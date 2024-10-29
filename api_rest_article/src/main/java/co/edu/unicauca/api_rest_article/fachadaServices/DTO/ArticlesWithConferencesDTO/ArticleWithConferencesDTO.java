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
