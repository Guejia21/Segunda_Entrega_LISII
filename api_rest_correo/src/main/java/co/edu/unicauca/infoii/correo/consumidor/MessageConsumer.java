/**
 * Clase que recibe mensajes de la cola de mensajes utilizando RabbitMQ 
 * @author David Chacón <jhoanchacon@unicauca.edu.co>
 * @author Jonathan Guejia <jonathanguejia@unicauca.edu.co>
 * @version 1.0
 * @since 2024
 */

package co.edu.unicauca.infoii.correo.consumidor;

import org.springframework.stereotype.Service;
import co.edu.unicauca.infoii.correo.DTOs.ArticleDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Service
public class MessageConsumer {

    @RabbitListener(queues = "temaCorreo")

    /**
     * Permite recibir mensaje de la cola de mensajes
     * @param objArticleCreated artículo recibido
     */
    public void receiveMessage(ArticleDTO objArticleCreated) {
        System.out.println("Datos del articulo recibidos");
        System.out.println("Enviando correo electrónico");
        System.out.println("Id: " + objArticleCreated.getId());
        System.out.println("Nombre: " + objArticleCreated.getNombre());
        System.out.println("Autores:" + objArticleCreated.getAutores());
        System.out.println("Cantidad de autores: " + objArticleCreated.getCantAutores());
        System.out.println("Revista: " + objArticleCreated.getRevista());
    }
}
    