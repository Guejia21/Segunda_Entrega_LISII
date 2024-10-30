/**
 * Clase que se encarga de realizar peticiones al servicio web de Articulos
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
    private String endPoint; /*Ruta al servicio web*/
    private Client objClientePeticiones; /*Cliente para realizar peticiones al servicio web*/
    public ArticuloServices(){
        this.endPoint = "http://localhost:8000/api/articles";
        this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }
    /**
     * Metodo que se encarga de almacenar un articulo en la base de datos
     * @param objArticuloRegistrar Objeto de tipo Articulo que se desea almacenar
     * @return Objeto de tipo Articulo que se almaceno en la base de datos
     */
    public Articulo almacenarArticulo(Articulo objArticuloRegistrar){
        Articulo art;
        WebTarget target = this.objClientePeticiones.target(this.endPoint);
        Entity<Articulo> data = Entity.entity(objArticuloRegistrar,MediaType.APPLICATION_JSON);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        art = objPeticion.post(data,Articulo.class);
        notifyAllObserves();
        return art;        
    }
    /**
     * Metodo que se encarga de listar todos los articulos almacenados en la base de datos
     * @return Lista de objetos de tipo Articulo
     */
    public List<Articulo> listarArticulos(){
        List<Articulo> articulos;
        WebTarget target = this.objClientePeticiones.target(this.endPoint+"/list");
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        articulos = objPeticion.get(new GenericType<List<Articulo>>(){});
        return articulos;
    }
    /**
     * Metodo que se encarga de eliminar un articulo de la base de datos
     * @param idArticulo Identificador del articulo que se desea eliminar
     * @return True si se elimino el articulo, False en caso contrario
     */
    public boolean eliminarArticulo(int idArticulo){
        Boolean bandera;
        WebTarget target = this.objClientePeticiones.target(this.endPoint+"/"+idArticulo);
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        bandera = objPeticion.delete(Boolean.class);
        notifyAllObserves();
        return bandera;
    }
    /**
     * Metodo que se encarga de consultar un articulo de la base de datos
     * @param idArticulo Identificador del articulo que se desea consultar
     * @return Objeto de tipo Articulo
     */
    public Articulo consultarArticulo(int idArticulo){
        Articulo art;
        WebTarget target = this.objClientePeticiones.target(this.endPoint+"/"+idArticulo);      
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        art = objPeticion.get(Articulo.class);      
        return art;        
    }
    /**
     * Metodo que se encarga de actualizar un articulo de la base de datos
     * @param idArticulo Identificador del articulo que se desea actualizar
     * @param artActualizado Objeto de tipo Articulo con los datos actualizados
     * @return Objeto de tipo Articulo con los datos actualizados
     */
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
