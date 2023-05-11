package app;

import java.util.Scanner;

import app.commandline.AdminCommandLine;
import app.commandline.PersonaCommandLine;
import app.commandline.ProductoCommandLine;

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

		System.out.print("Seleciona una opcion : \n1)Registrarse \n2)Hacer Login \n3)Salir "
				+ "\n4)Registrar Categoria Producto. \n5) Crear privilegio");

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
		
		if (opcion == 5) {
			AdminCommandLine.crearPrivilegio(scanner);
		}
		

		return opcion;
	}
	
	
	public static void limpiarConsola() {  
		// implementar limpiar consola.

	}  

}
