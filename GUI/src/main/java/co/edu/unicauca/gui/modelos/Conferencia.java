/**
 * Clase Conferencia
 */
package co.edu.unicauca.gui.modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conferencia {
    private int id;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private int cantidadMaxArticulos;
    private float costoInscripcion;
    private List<Articulo> articulos;

    public Conferencia() {
    }

    public Conferencia(String nombre, Date fechaInicio, Date fechaFin,float costo, int cantidadMaxArticulos) {
        this.id =0;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidadMaxArticulos = cantidadMaxArticulos;
        this.costoInscripcion = costo;
        this.articulos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public float getCostoInscripcion() {
        return costoInscripcion;
    }

    public void setCosto(int costo) {
        this.costoInscripcion = costo;
    }
    

    public int getCantidadMaxArticulos() {
        return cantidadMaxArticulos;
    }

    public void setCantidadMaxArticulos(int cantidadMaxArticulos) {
        this.cantidadMaxArticulos = cantidadMaxArticulos;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }
    @Override
    public String toString()
    {
        return this.nombre;
    }
    
    
    
}
