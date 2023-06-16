package com.tienda.online.app.cmd.commandline;


import com.tienda.online.dao.modelo.CategoriaProducto;
import com.tienda.online.service.CategoriaProductoRegistrationService;

import java.util.Scanner;
import java.util.UUID;

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
	
	public static void crearProducto(Scanner scanner) {
		
		String id = UUID.randomUUID().toString();
		
		System.out.println("Descripcion del producto: ");
		
		String descripcionProducto = scanner.nextLine();
		
		System.out.println("Categoria del producto: ");
		
		//todo: pendiente cargar todas las categorias de producto ya 
		//registradas y presentarselo al usuario como un menu
		
		
	}
}
