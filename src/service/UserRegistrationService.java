package service;

import dao.compartido.Linea;
import dao.modelo.Usuario;

import java.util.UUID;

import dao.compartido.EscritorDeArchivoDeTexto;
import dao.persona.PersonSerializer;
import dao.usuario.UsuarioSerializer;
import service.dto.UserDto;
import dao.modelo.Persona;

public class UserRegistrationService {

	private final EscritorDeArchivoDeTexto escritor;
	
	private static final String ARCHIVO_PERSONAS = "archivo_personas";
	
	private static final String ARCHIVO_USUARIOS = "archivo_usuarios";
	

	public UserRegistrationService(){
		this.escritor = new EscritorDeArchivoDeTexto();
	}
	
	public boolean createUser(UserDto userData) {
		Linea archivoTexto = new Linea();
		
		userData.setId(UUID.randomUUID().toString());
		
		Persona nuevaPersona = new Persona();
		
		nuevaPersona.setEmailAdress(userData.getEmailAdress());
		nuevaPersona.setId(userData.getId());
		nuevaPersona.setName(userData.getName());
		nuevaPersona.setMyFirstLastname(userData.getMyFirstLastname());
		nuevaPersona.setMySecondLastname(userData.getMySecondLastname());
		nuevaPersona.setMyDateOfBirth(userData.getMyDateOfBirth());
		nuevaPersona.setSex(userData.getSex());
		
		
		Usuario usuario = new Usuario();
		
		usuario.setId(userData.getId());
		usuario.setUserName(userData.getUserName());
		usuario.setPassword(userData.getPassword());
		
		
		PersonSerializer serializer = new PersonSerializer(nuevaPersona);
		String personaValor = serializer.serializar();
		archivoTexto.setContenido(personaValor);
		escritor.escribir(ARCHIVO_PERSONAS, archivoTexto);
		return crearUsuario(usuario);
	}
	
	private boolean crearUsuario(Usuario usuario) {
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
