package co.edu.unicauca.api_rest_article.capaAccesoADatos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticleEntity {
    private int id;
    private String nombre;
    private String autores[];
    private int cantAutores;
    private String revista;
    
    public ArticleEntity(){
            
    }
}
