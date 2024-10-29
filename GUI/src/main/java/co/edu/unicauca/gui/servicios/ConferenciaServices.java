/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.gui.servicios;

import co.edu.unicauca.gui.infraestructura.Subject;
import co.edu.unicauca.gui.modelos.Conferencia;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author david
 */
public class ConferenciaServices extends Subject {
    private String endPoint; //ruta al servicio web, puerto:8000
    private Client objClientePeticiones;
    public ConferenciaServices(){
        this.endPoint = "http://localhost:8080/api/conferences";
        this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }
    public Conferencia  almacenarConferencia(Conferencia objConferenciaRegistrar){
        Conferencia conf;
        WebTarget target = this.objClientePeticiones.target(this.endPoint);
        Entity<Conferencia> data = Entity.entity(objConferenciaRegistrar,MediaType.APPLICATION_JSON);
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        conf = objPeticion.post(data,Conferencia.class);
        notifyAllObserves();
        return conf;
    }
    public List<Conferencia> listarConferencias(){
       List<Conferencia> conferencias;
        WebTarget target = this.objClientePeticiones.target(this.endPoint+"/list");
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        conferencias = objPeticion.get(new GenericType<List<Conferencia>>(){});
        return conferencias;
    }
    //TO DO: Eliminar conferencia e implementar notify
}
