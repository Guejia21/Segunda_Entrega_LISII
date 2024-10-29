package co.edu.unicauca.infoii.correo.consumidor;

import org.springframework.stereotype.Service;

import co.edu.unicauca.infoii.correo.DTOs.ClienteDTO;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Service
public class MessageConsumer {

    @RabbitListener(queues = "temaCorreo")
    public void receiveMessage(ClienteDTO objClienteCreado) {
        System.out.println("Datos del cliente recibidos");
        System.out.println("Enviando correo electrónico");
        System.out.println("Id: "+objClienteCreado.getId());
        System.out.println("Nombre: "+objClienteCreado.getNombre());
        System.out.println("Apellido: "+objClienteCreado.getApellido());
        System.out.println("Fecha de creación: "+objClienteCreado.getCreateAt());        
    }
}
    