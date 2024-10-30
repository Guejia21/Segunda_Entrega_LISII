package co.edu.unicauca.api_rest_article.fachadaServices.DTO.CRUDArticleDTO;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticleDTO implements Serializable{
    private int id;
    private String nombre; 
    private String autores[];
    private int cantAutores;
    private String revista;    
    public ArticleDTO(){
            
    }
}
