package service;

import dao.compartido.Linea;
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
		Linea archivoTexto = new Linea();
		PersonSerializer serializer = new PersonSerializer(persona);
		String personaValor = serializer.serializar();
		archivoTexto.setContenido(personaValor);
		escritor.escribir(ARCHIVO_PERSONAS, archivoTexto);
		return true;
	}
	
	public boolean crearUsuario(Usuario usuario) {
		var linea = convertir(usuario);
		escritor.escribir(ARCHIVO_USUARIOS, linea);
		return true;
	}
	
	
	public Linea convertir(Usuario usuario) {
	
		Linea archivoTexto = new Linea();
		UsuarioSerializer serializer = new UsuarioSerializer(usuario);
		String UsuarioValor = serializer.serializar();
		archivoTexto.setContenido(UsuarioValor);
		
		return archivoTexto;
	}
	
}
