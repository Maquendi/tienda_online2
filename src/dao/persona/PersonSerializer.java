package dao.persona;

import dao.compartido.Serializador;
import modelo.Persona;

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
				.append(persona.getNombre())
				.append(SEPARATOR)
				.append(persona.getApellidoPaterno())
				.append(SEPARATOR)
				.append(persona.getApellidoMaterno())
				.append(SEPARATOR)
				.append(persona.getSexo())
				.append(SEPARATOR)
				.append(persona.getFechaDeNacimiento())
				.append(SEPARATOR)
				.append(persona.getEmail())
				.toString();
	}

}
