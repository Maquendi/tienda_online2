package app.commandline;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import modelo.Persona;
import modelo.Usuario;
import service.PersonRegistrationService;

public class PersonaCommandLine {
	
	
	public static void registrar(Scanner scanner) {
		
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
	    
	    System.out.print("Fecha Nacimiento (año,mes,dia): ");

	    String fechaNacimeinto = scanner.nextLine();
	    
	    Persona persona = new Persona();
	    
	    String id=UUID.randomUUID().toString();
	   
	    persona.setId(id);
	    persona.setNombre(nombre);
	    persona.setApellidoPaterno(appelidoPaterno);
	    persona.setApellidoMaterno(appelidoMaterno);
	    persona.setEmail(correo);
	    persona.setSexo(genero);
	    // 1989, 04, 25. 
	    
	    try {
	    	// hdsf,dsfue,dfuyse.
	    	// "" -->> []
	    	
	    	// "2007,02,25" -->> [2007,02,25]
	    	
	    	// "2007,02" -->> [2007,02]
	    	
	    	
	    	// Checked exception
	    	// Unchecked exception
	    	
	         // 1: Exception
	    	
	    	//  2: RuntimeException
	    	
	    	
	    	
	    	String[] datosDeNacimiento = fechaNacimeinto.split(",");
	    	int ano = Integer.valueOf(datosDeNacimiento[0]);
	    	int mes = Integer.valueOf(datosDeNacimiento[1]);
	    	int dia = Integer.valueOf(datosDeNacimiento[2]);
	    	LocalDate fechaDeNacimiento = LocalDate.of(ano, mes, dia);
	    	persona.setFechaDeNacimiento(fechaDeNacimiento);
	    	PersonRegistrationService registrationService = new PersonRegistrationService();
	    	
	    	registrationService.crearPersona(persona);
	    	System.out.println("Ya se ha creado una nueva persona.");
	    	
	    	crearUsuario(scanner, id);
	    	
	    }catch(NumberFormatException  e) {
	    	System.out.println("El valor de la fecha de nacimiento no es valido.");
	    }catch(IndexOutOfBoundsException e) {
			System.out.println("El formato de la fecha de nacimiento no es valido.");
	    } 
	}
	
	/**
	 * 	 tomar datos del usuario, es decir: username y password. 
	 * y guardarlo en archivo de texto archivo_usuarios.txt
	 * @param scanner
	 * @param id
	 */
	public static void crearUsuario(Scanner scanner, String id) {

		
		System.out.println("Usuario:" );
		
		String userName = scanner.nextLine();
		
		System.out.println("Contraseña: ");
		
		String passWord = scanner.nextLine();
		
		Usuario usuario = new Usuario();
		
		usuario.setId(id);
		
		usuario.setUserName(userName);
		
		usuario.setPassword(passWord);
		
		PersonRegistrationService registrationService = new PersonRegistrationService();
		registrationService.crearUsuario(usuario);
		System.out.println("Ya se ha creado un nuevo usuario");
	}
}
