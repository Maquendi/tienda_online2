package app.commandline;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;
import modelo.Persona;
import modelo.Usuario;
import service.PersonRegistrationService;

public class PersonaCommandLine {
	
	
	public static void registrar() {
		
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object
		
	    System.out.print("Nombre: ");

	    String nombre = scanner.nextLine();
	    
	    System.out.print("Appellido Paterno: ");

	    String appelidoPaterno = scanner.nextLine();
	    
	    System.out.print("Appellido Materno: ");

	    String appelidoMaterno = scanner.nextLine();
	    
	    System.out.print("Correo electronico: ");

	    String correo = scanner.nextLine();
	    
	    System.out.print("Genero: ");

	    String genero = scanner.nextLine();
	    
	    System.out.print("Fecha Nacimiento: ");

	    String fechaNacimeinto = scanner.nextLine();
	    
	    Persona persona = new Persona();
	   
	    persona.setId(UUID.randomUUID().toString());
	    persona.setNombre(nombre);
	    persona.setApellidoPaterno(appelidoPaterno);
	    persona.setApellidoMaterno(appelidoMaterno);
	    persona.setEmail(correo);
	    persona.setSexo(genero);
	    // 1989, 04, 25. 
	    
	    try {
	    	String[] datosDeNacimiento = fechaNacimeinto.split(",");
	    	
	    	int ano = Integer.valueOf(datosDeNacimiento[0]);
	    	int mes = Integer.valueOf(datosDeNacimiento[1]);
	    	int dia = Integer.valueOf(datosDeNacimiento[2]);
	    	LocalDate fechaDeNacimiento = LocalDate.of(ano, mes, dia);
	    	persona.setFechaDeNacimiento(fechaDeNacimiento);
	    	
	    	PersonRegistrationService registrationService = new PersonRegistrationService();
	    	
	    	registrationService.crearPersona(persona);
	    	System.out.println("Ya se ha creado una nueva persona.");
	    	
	    	// llamar 
	    	
	    	crearUsuario();
	    	
	    }catch(NumberFormatException  e) {
	    	System.out.println("El valor de la fecha de nacimiento no es valido.");
	    }
	    
	    scanner.close();
	}
	
	public static void crearUsuario() {
		// tomar datos del usuario, es decir: username y password. 
		//y guardarlo en archivo de texto archivo_usuarios.txt
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Usuario:" );
		
		String userName = scanner.nextLine();
		
		System.out.println("Contraseña: ");
		
		String passWord = scanner.nextLine();
		
		Usuario usuario = new Usuario();
		
		usuario.setId(UUID.randomUUID().toString());
		
		usuario.setUserName(userName);
		
		usuario.setPassword(passWord);
		
		PersonRegistrationService registrationService = new PersonRegistrationService();
		registrationService.crearUsuario(usuario);
		System.out.println("Ya se ha creado un nuevo usuario");
		
		
	}
}
