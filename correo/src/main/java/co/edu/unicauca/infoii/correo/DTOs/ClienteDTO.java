package co.edu.unicauca.infoii.correo.DTOs;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClienteDTO {
	private Integer id;
	private String nombre;
	private String apellido;
	private String email;
	private Date createAt;	
	public ClienteDTO() {

	}
}