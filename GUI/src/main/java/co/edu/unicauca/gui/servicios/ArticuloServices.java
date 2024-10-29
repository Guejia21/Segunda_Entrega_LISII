/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.gui.servicios;

import co.edu.unicauca.gui.infraestructura.Subject;
import co.edu.unicauca.gui.modelos.Articulo;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author david
 */
public class ArticuloServices extends Subject{
    private String endPoint; //ruta al servicio web, puerto:8000
    private Client objClientePeticiones;
    public ArticuloServices(){
        this.endPoint = "http://localhost:8000/api/articles";
        this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }
    public Articulo almacenarArticulo(Articulo objArticuloRegistrar){
        Articulo art;
        WebTarget target = this.objClientePeticiones.target(this.endPoint);
        Entity<Articulo> data = Entity.entity(objArticuloRegistrar,MediaType.APPLICATION_JSON);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        art = objPeticion.post(data,Articulo.class);
        notifyAllObserves();
        return art;        
    }
    public List<Articulo> listarArticulos(){
       List<Articulo> articulos;
        WebTarget target = this.objClientePeticiones.target(this.endPoint+"/list");
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        articulos = objPeticion.get(new GenericType<List<Articulo>>(){});
        return articulos;
    }
    public boolean eliminarArticulo(int idArticulo){
        Boolean bandera;
        WebTarget target = this.objClientePeticiones.target(this.endPoint+"/"+idArticulo);
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        bandera = objPeticion.delete(Boolean.class);
        notifyAllObserves();
        return bandera;
    }
    public Articulo consultarArticulo(int idArticulo){
        Articulo art;
        WebTarget target = this.objClientePeticiones.target(this.endPoint+"/"+idArticulo);      
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        art = objPeticion.get(Articulo.class);      
        return art;        
    }
    public Articulo actualizarArticulo(int idArticulo,Articulo artActualizado){
        Articulo art;
        WebTarget target = this.objClientePeticiones.target(this.endPoint+"/"+idArticulo);
        Entity<Articulo> data = Entity.entity(artActualizado,MediaType.APPLICATION_JSON);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        art = objPeticion.put(data,Articulo.class);
        notifyAllObserves();
        return art;   
    }
    
}
