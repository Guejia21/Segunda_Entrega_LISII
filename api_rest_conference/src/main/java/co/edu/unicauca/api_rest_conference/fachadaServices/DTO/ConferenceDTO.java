package co.edu.unicauca.api_rest_conference.fachadaServices.DTO;

import java.util.Date;
import java.util.List;

import co.edu.unicauca.api_rest_conference.capaAccesoADatos.models.ArticleEntity;
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
    private List<ArticleEntity> articulos;
    public ConferenceDTO() {
    }  
}
