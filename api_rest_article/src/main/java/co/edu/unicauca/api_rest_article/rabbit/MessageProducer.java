/**
 * Clase que envía mensajes a la cola de mensajes utilizando RabbitMQ 
 * @author David Chacón <jhoanchacon@unicauca.edu.co>
 * @author Jonathan Guejia <jonathanguejia@unicauca.edu.co>
 * @version 1.0
 * @since 2024
 */

package co.edu.unicauca.api_rest_article.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import co.edu.unicauca.api_rest_article.fachadaServices.DTO.CRUDArticleDTO.ArticleDTO;

@Service
public class MessageProducer {

    private final AmqpTemplate amqpTemplate;
    private final String exchange = "myExchange";
    private final String routingKey = "routingKey";

    /**
     * Permite producir mensaje
     * @param amqpTemplate
     */
    public MessageProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    /**
     * Permite enviar el mensaje
     * @param objArticuloCreado
     */
    public void sendMessage(ArticleDTO objArticuloCreado) {
        amqpTemplate.convertAndSend(exchange, routingKey, objArticuloCreado);
        System.out.println("Datos del articulo enviados a la cola");
    }
}
    