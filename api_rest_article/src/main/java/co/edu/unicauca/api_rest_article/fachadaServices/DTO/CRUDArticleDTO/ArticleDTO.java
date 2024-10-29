package co.edu.unicauca.api_rest_article.fachadaServices.DTO.CRUDArticleDTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticleDTO {
    private int id;
    private String nombre;
    private String autores[];
    private int cantAutores;
    private String revista;
    private List<ConferenceDTO> conferences;
    public ArticleDTO(){
            
    }
}