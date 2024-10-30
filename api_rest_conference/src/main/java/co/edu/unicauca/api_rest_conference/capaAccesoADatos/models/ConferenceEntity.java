/**
 * Clase que representa una conferencia en un sistema de gestión de conferencias.
 * @author David Chacón <jhoanchacon@unicauca.edu.co>
 * @author Jonathan Guejia <jonathanguejia@unicauca.edu.co>
 * @version 1.0
 * @since 2024
 */

package co.edu.unicauca.api_rest_conference.capaAccesoADatos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ConferenceEntity {
    private int id;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private int cantidadMaxArticulos;
    private float costoInscripcion;
    private List<ArticleEntity> articulos;
    public ConferenceEntity() {
    }   
}
