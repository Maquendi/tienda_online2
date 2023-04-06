package service;

import dao.compartido.Archivo;
import dao.compartido.EscritorDeArchivoDeTexto;
import dao.persona.PersonSerializer;
import dao.usuario.UsuarioSerializer;
import modelo.Persona;
import modelo.Usuario;

public class PersonRegistrationService {

	private final EscritorDeArchivoDeTexto escritor;
	
	private static final String ARCHIVO_PERSONAS = "archivo_personas";
	
	private static final String ARCHIVO_USUARIOS = "archivo_usuarios";
	

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
		
		Archivo archivoTexto = new Archivo();
		archivoTexto.setNombreArchivo(ARCHIVO_USUARIOS);
		UsuarioSerializer serializer = new UsuarioSerializer(usuario);
		String UsuarioValor = serializer.serializar();
		archivoTexto.setContenido(UsuarioValor);
		escritor.crear(archivoTexto);
		return true;
	}
}