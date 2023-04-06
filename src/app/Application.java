package app;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

import dao.compartido.Archivo;
import dao.compartido.EscritorDeArchivoDeTexto;
import dao.compartido.LectorDeArchivoDeTexto;
import dao.persona.PersonDeserializer;
import dao.persona.PersonSerializer;
import dao.usuario.UsuarioDeserializer;
import dao.usuario.UsuarioSerializer;
import modelo.Persona;
import modelo.Usuario;
import service.PersonRegistrationService;

public class Application {
	
	
	public static void main(String[] args) {
		
		try {
			CommandLineApplication.init();
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	public static void crearUsuario() {
		Usuario user = new Usuario();
		
		user.setId(UUID.randomUUID().toString());
		user.setUserName("maquendi");
		user.setPassword("my_secret_password");

		UsuarioSerializer serializer = new UsuarioSerializer(user);
		
		String usuarioLinea = serializer.serializar();
		
		Archivo archivoTexto = new Archivo();
		
		
		archivoTexto.setNombreArchivo("archivo_usuarios");
		archivoTexto.setContenido(usuarioLinea);
		
		EscritorDeArchivoDeTexto escritor = new EscritorDeArchivoDeTexto();
		escritor.crear(archivoTexto);
	}
	
	
	
	
	
	
	public static void probarLeerPersona() {
		
		LectorDeArchivoDeTexto lector = new LectorDeArchivoDeTexto();
		
		Object[] personasLeidas = lector.leer("archivo_personas", new PersonDeserializer());
		
		
		System.out.println(Arrays.toString(personasLeidas));
	}
	
	public static void probarCrearPersona() {
		
		Persona maquendi = new Persona();
		maquendi.setNombre("Maquendi");
		maquendi.setApellidoPaterno("Beltran");
		maquendi.setApellidoMaterno("Novas");
		maquendi.setEmail("mbn04251989@gmail.com");
		maquendi.setFechaDeNacimiento(LocalDate.of(1989, 04, 25));
		maquendi.setSexo("M");
		maquendi.setId(UUID.randomUUID().toString());
		
		PersonRegistrationService registrationService = new PersonRegistrationService();
		registrationService.crearPersona(maquendi);
	}
}
