package app;

import java.util.Scanner;

import app.commandline.AdminCommandLine;
import app.commandline.PersonaCommandLine;
import app.commandline.ProductoCommandLine;
import app.commandline.AdminCommandLine;
import app.commandline.*;

public class CommandLineApplication {

	public static void init() {
		Scanner scanner = new Scanner(System.in);
		int opcionSeleccionado;
		try {

			do {
				
				limpiarConsola();
				
				opcionSeleccionado = mostrarMenu(scanner);
				
			} while (opcionSeleccionado != 3);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		scanner.close();
	}

	// checked exception.
	public static int mostrarMenu(Scanner scanner) throws Exception {

		int opcion;

		System.out.println("Seleciona una opcion : \n1)Registrarse \n2)Hacer Login \n3)Salir \n4)Registrar Categoria Producto ");

		opcion = Integer.parseInt(scanner.nextLine());

		if (opcion == 1) {

			PersonaCommandLine.registrar(scanner);
		}

		if (opcion == 2) {
			
			throw new Exception("Esta funcion aun no esta implementada");
		}

		if (opcion == 3) {
			 System.exit(0);
		}
		
		if (opcion == 4) {
			ProductoCommandLine.crearCategoriaProducto(scanner);
		}
		
		
		if(opcion == 6) {
			CuentaBancariaCommandLine.registrar(scanner);
		}
		
		if(opcion == 7) {
			AdminCommandLine.CrearRol(scanner);
		}

		return opcion;
	}
	
	
	public static void limpiarConsola() {  
		// implementar limpiar consola.

	}  

}
