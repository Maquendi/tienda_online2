package app.commandline;

import java.util.Scanner;
import java.util.UUID;

import modelo.Privilegio;
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
	
	
	
}
