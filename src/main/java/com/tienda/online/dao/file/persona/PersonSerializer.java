package com.tienda.online.dao.file.persona;

import com.tienda.online.dao.file.compartido.Serializador;
import com.tienda.online.dao.modelo.Persona;


public class PersonSerializer implements Serializador {

	 private final Persona persona;
	 
	 public PersonSerializer(Persona persona) {
		 this.persona = persona;
	 }
	
	// Yefri,Feliz,Guillen,M,felizguillen@gmail.com,15-05-2010

	// nombre,appellidoPaterno,apellidoMaterno,sexo,email,fechaNacimiento

	@Override
	public String serializar() {

		final var SEPARATOR = ",";

		var personStringBuilder = new StringBuilder();

		return personStringBuilder
				.append(persona.getId())
				.append(SEPARATOR)
				.append(persona.getName())
				.append(SEPARATOR)
				.append(persona.getMyFirstLastname())
				.append(SEPARATOR)
				.append(persona.getMySecondLastname())
				.append(SEPARATOR)
				.append(persona.getSex())
				.append(SEPARATOR)
				.append(persona.getMyDateOfBirth())
				.append(SEPARATOR)
				.append(persona.getEmailAdress())
				.toString();
	}

}
