package co.edu.unicauca.api_rest_article.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import co.edu.unicauca.api_rest_article.fachadaServices.DTO.CRUDArticleDTO.ArticleDTO;

@Service
public class MessageProducer {

    private final AmqpTemplate amqpTemplate;
    private final String exchange = "myExchange";
    private final String routingKey = "routingKey";

    public MessageProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendMessage(ArticleDTO objArticuloCreado) {
        amqpTemplate.convertAndSend(exchange, routingKey, objArticuloCreado);
        System.out.println("Datos del articulo enviado a la cola");
    }
}
    