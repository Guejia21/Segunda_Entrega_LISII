/**
 * Clase que representa un artículo en un sistema de gestión de conferencias.
 * @author David Chacón <jhoanchacon@unicauca.edu.co>
 * @author Jonathan Guejia <jonathanguejia@unicauca.edu.co>
 * @version 1.0
 * @since 2024
 */
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
    private String autores;
    private int cantAutores;
    private String revista;
    
    public ArticleEntity(){
            
    }
}
