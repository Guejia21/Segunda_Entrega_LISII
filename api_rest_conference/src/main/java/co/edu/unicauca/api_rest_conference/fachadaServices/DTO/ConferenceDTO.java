/**
 * Clase que representa una conferencia DTO.
 * @author David Chacón <jhoanchacon@unicauca.edu.co>
 * @author Jonathan Guejia <jonathanguejia@unicauca.edu.co>
 * @version 1.0
 * @since 2024
 */

package co.edu.unicauca.api_rest_conference.fachadaServices.DTO;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConferenceDTO {
    private int id;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private int cantidadMaxArticulos;
    private float costoInscripcion;
    private List<ArticleDTO> articulos;
    
    public ConferenceDTO() {
    }  
}
 