package dao.persona;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dao.compartido.DeSerializer;
import dao.modelo.Persona;

public class PersonDeserializer implements DeSerializer {

	@Override
	public Object deSerializar(String linea) {
		final String SEPARATOR = ",";
		// 4ea38fb6-6ca7-4721-a73f-0aa9e949cab2,Maquendi,Beltran,Novas,1989-04-25,mbn04251989@gmail.com

		String[] attributosPersona = linea.split(SEPARATOR);

		Persona persona = new Persona();

		persona.setId(attributosPersona[0]);
		persona.setName(attributosPersona[1]);
		persona.setMyFirstLastname(attributosPersona[2]);
		persona.setMySecondLastname(attributosPersona[3]);
		persona.setSex(attributosPersona[4]);
		// 1989-04-25
		// 25-04-1989
		// 1989/04/25
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		var fechaNacimiento = LocalDate.parse(attributosPersona[5], dateFormatter);
		persona.setMyDateOfBirth(fechaNacimiento);
		persona.setEmailAdress(attributosPersona[6]);
		return persona;
	}

}
