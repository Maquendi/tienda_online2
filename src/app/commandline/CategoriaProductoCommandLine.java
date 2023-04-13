package app.commandline;

import java.util.Scanner;

import modelo.CategoriaProducto;
import service.CategoriaProductoRegistrationService;

public class CategoriaProductoCommandLine {

public static void crearCategoriaProducto(Scanner scanner) {
		
		System.out.println("id: ");
		
		String id =scanner.nextLine();
		
		System.out.println("Categoria Producto: ");
		
		String NombreCategoriaProducto=scanner.nextLine();
		
		CategoriaProducto categoriaProducto = new CategoriaProducto();
		
		categoriaProducto.setId(id);
		
		categoriaProducto.setNombreDeCategoria(NombreCategoriaProducto);
		
		CategoriaProductoRegistrationService registrationService = new CategoriaProductoRegistrationService();
		
		registrationService.crearCategoriaProducto(categoriaProducto);
		
		System.out.println("Usted ha accedido a una categoria de productos");
		
	}
}
