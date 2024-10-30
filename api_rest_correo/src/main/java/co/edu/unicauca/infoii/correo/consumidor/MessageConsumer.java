package co.edu.unicauca.infoii.correo.consumidor;

import org.springframework.stereotype.Service;

import co.edu.unicauca.infoii.correo.DTOs.ArticleDTO;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Service
public class MessageConsumer {

    @RabbitListener(queues = "temaCorreo")
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
    