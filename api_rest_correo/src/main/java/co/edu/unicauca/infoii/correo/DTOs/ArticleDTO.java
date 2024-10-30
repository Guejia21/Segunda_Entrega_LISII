/**
 * Clase que representa la clase DTO para artículo. 
 * @author David Chacón <jhoanchacon@unicauca.edu.co>
 * @author Jonathan Guejia <jonathanguejia@unicauca.edu.co>
 * @version 1.0
 * @since 2024
 */

package co.edu.unicauca.infoii.correo.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticleDTO {
    private int id;
    private String nombre;
    private String autores;
    private int cantAutores;
    private String revista;

    public ArticleDTO(){}
}
