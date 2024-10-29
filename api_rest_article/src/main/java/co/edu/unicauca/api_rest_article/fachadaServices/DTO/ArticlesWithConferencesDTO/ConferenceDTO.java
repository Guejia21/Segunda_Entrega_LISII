package co.edu.unicauca.api_rest_article.fachadaServices.DTO.ArticlesWithConferencesDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConferenceDTO {
    private int id;
    private String name;
    private int maxArticlesCuantity;
    public ConferenceDTO() {
    }  
}
