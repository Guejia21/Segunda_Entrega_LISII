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
