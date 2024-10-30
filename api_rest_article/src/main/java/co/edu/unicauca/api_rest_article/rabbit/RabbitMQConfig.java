/**
 * Clase que representa la configuración del publicador en RabbitMQ 
 * @author David Chacón <jhoanchacon@unicauca.edu.co>
 * @author Jonathan Guejia <jonathanguejia@unicauca.edu.co>
 * @version 1.0
 * @since 2024
 */

package co.edu.unicauca.api_rest_article.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;


@Configuration
public class RabbitMQConfig {

    /**
     * Definición de la cola
     * @return
     */
    @Bean
    public Queue myQueue() {
        return new Queue("temaCorreo", true);
    }

    /**
     * Definición de exchange
     * @return
     */
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("myExchange");
    }

    /**
     * Definición del biding
     * @param myQueue cola
     * @param exchange exchange
     * @return
     */
    @Bean
    public Binding binding(Queue myQueue, DirectExchange exchange) {
        return BindingBuilder.bind(myQueue).to(exchange).with("routingKey");
    }

    /**
     * Convertidor de jackson
     * @return
     */
    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * Configura y crea una instancia de `RabbitTemplate` para enviar y recibir mensajes en formato JSON utilizando RabbitMQ.
     * @param connectionFactory
     * @return
     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        return rabbitTemplate;
    }
}
    