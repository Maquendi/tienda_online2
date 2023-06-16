package app.commandline;
import java.util.Scanner;


import java.util.UUID;

import dao.modelo.Privilegio;
import dao.modelo.Rol;
import service.PrivilegioRegistrationService;

public class AdminCommandLine {
	
	public static void crearPrivilegio(Scanner scanner) {

		System.out.print("Nombre privilegio: ");

		String nombre = scanner.nextLine();

		PrivilegioRegistrationService registrationService = new PrivilegioRegistrationService();

		var id = UUID.randomUUID().toString();

		registrationService.crearPrivilegio(new Privilegio(id, nombre));

		// placeholder
		System.out.println(String.format("Privilegio %s guardado con id %s", nombre, id));
	}
	
	public static void CrearRol(Scanner scanner) {
		
		System.out.print("Nombre rol: ");
		
		String nombreRol = scanner.nextLine();
		
		var id = UUID.randomUUID().toString();
		
		PrivilegioRegistrationService registrationService  = new PrivilegioRegistrationService();
		
		registrationService.crearRol(new Rol(id, nombreRol));
		
		System.out.println(String.format("Rol %s guardado con id %s ", nombreRol, id));
	}
}
