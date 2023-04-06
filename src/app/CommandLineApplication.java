package app;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

import app.commandline.PersonaCommandLine;
import modelo.Persona;
import service.PersonRegistrationService;

public class CommandLineApplication {

	public static void init() throws Exception {
		
		mostrarMenu();
		
	}
	
	public static void mostrarMenu() throws Exception {
		
		int opcion;
		
		Scanner scanner = new Scanner(System.in);
		
		do {
			
			System.out.print("Seleciona una opcion : \n1)Registrarse \n2)Hacer Login \n3)Salir" );
			
			opcion = scanner.nextInt();
			
		    if(opcion==1) {
		    	
			PersonaCommandLine.registrar();
			
		    }
		    
			if(opcion==2) {
				
				scanner.close();
				
				throw new Exception("Esta funcion aun no esta implementada");
						
			}
			
			if(opcion==3) {
				
				//scanner.close();
			}
		}while(opcion!=3);
	}
	
}
