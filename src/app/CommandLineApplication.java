package app;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

import app.commandline.PersonaCommandLine;
import modelo.Persona;
import service.PersonRegistrationService;

public class CommandLineApplication {

	public static void init() {
		
		// crear un menu con tres opciones. 1: Registrarse   ,2: Hacer Login, 3: Salir
		
//		if (opcion == 1) {
//			
//			PersonaCommandLine.registrar();
//		}
		
		System.out.print("Seleciona una opcion : \n1)Registrarse \n2)Hacer Login \n3)Salir" );
		
		Scanner scanner = new Scanner(System.in);
		
		int opcion = scanner.nextInt();
		
		if(opcion==1) {
			
			PersonaCommandLine.registrar();
		}
		
	}
	
}
