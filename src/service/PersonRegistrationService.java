package service;

import dao.compartido.Archivo;
import dao.compartido.EscritorDeArchivoDeTexto;
import dao.persona.PersonSerializer;
import modelo.Persona;
import modelo.Usuario;

public class PersonRegistrationService {

	private final EscritorDeArchivoDeTexto escritor;
	
	private static final String ARCHIVO_PERSONAS = "archivo_personas";
	

	public PersonRegistrationService(){
		this.escritor = new EscritorDeArchivoDeTexto();
	}
	
	public boolean crearPersona(Persona persona) {
		Archivo archivoTexto = new Archivo();
		archivoTexto.setNombreArchivo(ARCHIVO_PERSONAS);
		PersonSerializer serializer = new PersonSerializer(persona);
		String personaValor = serializer.serializar();
		archivoTexto.setContenido(personaValor);
		escritor.crear(archivoTexto);
		return true;
	}
	
	public boolean crearUsuario(Usuario usuario) {
		
		// implementar...
		
		return true;
	}
}
