package app.commandline;

import java.util.Scanner;
import java.util.UUID;

import modelo.CategoriaProducto;
import service.CategoriaProductoRegistrationService;

public class ProductoCommandLine {

	
	public static void crearCategoriaProducto(Scanner scanner) {

		String id = UUID.randomUUID().toString();
		
		System.out.print("Nombre categoria: ");

		String nombreCategoriaProducto = scanner.nextLine();

		CategoriaProducto categoriaProducto = new CategoriaProducto();

		categoriaProducto.setId(id);

		categoriaProducto.setNombreDeCategoria(nombreCategoriaProducto);

		CategoriaProductoRegistrationService registrationService = new CategoriaProductoRegistrationService();

		registrationService.crearCategoriaProducto(categoriaProducto);

		System.out.println("Se ha creado una nueva categoria de productos con nombre: " + nombreCategoriaProducto);
	}
}
