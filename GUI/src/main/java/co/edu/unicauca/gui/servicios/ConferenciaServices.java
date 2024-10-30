/**
 * Clase que se encarga de realizar peticiones al servicio web de Conferencias
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


public class ConferenciaServices extends Subject {
    private String endPoint; /*Ruta al servicio web*/
    private Client objClientePeticiones; /*Cliente para realizar peticiones al servicio web*/
    public ConferenciaServices(){
        this.endPoint = "http://localhost:8080/api/conferences";
        this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }
    /**
     * Metodo que se encarga de almacenar una conferencia en la base de datos
     * @param objConferenciaRegistrar Objeto de tipo Conferencia que se desea almacenar
     * @return Objeto de tipo Conferencia que se almaceno en la base de datos
     */
    public Conferencia  almacenarConferencia(Conferencia objConferenciaRegistrar){
        Conferencia conf;
        WebTarget target = this.objClientePeticiones.target(this.endPoint);
        Entity<Conferencia> data = Entity.entity(objConferenciaRegistrar,MediaType.APPLICATION_JSON);
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        conf = objPeticion.post(data,Conferencia.class);
        notifyAllObserves();
        return conf;
    }
    /**
     * Metodo que se encarga de listar todas las conferencias almacenadas en la base de datos
     * @return Lista de objetos de tipo Conferencia
     */
    public List<Conferencia> listarConferencias(){
        List<Conferencia> conferencias;
        WebTarget target = this.objClientePeticiones.target(this.endPoint+"/list");
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        conferencias = objPeticion.get(new GenericType<List<Conferencia>>(){});
        return conferencias;
    }    
}
