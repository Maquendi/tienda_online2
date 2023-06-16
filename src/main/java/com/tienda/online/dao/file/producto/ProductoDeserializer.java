package com.tienda.online.dao.file.producto;

import com.tienda.online.dao.file.compartido.DeSerializer;
import com.tienda.online.dao.modelo.CategoriaProducto;
import com.tienda.online.dao.modelo.Producto;

public class ProductoDeserializer implements DeSerializer{

	public Object deSerializar(String linea) {
		
		final String SEPARATOR = ",";
		
		String[] attributosProducto = linea.split(SEPARATOR);
		
	    Producto producto = new Producto();
		
		producto.setId(attributosProducto[0]);
		producto.setDescripcion(attributosProducto[1]);
		
		CategoriaProducto catProducto = new CategoriaProducto();
		
		catProducto.setId(attributosProducto[2]);
		
		//nota: pendiente cargar nombre de categoria
		
		producto.setCategoria(catProducto);
		
		return producto;
		
		
	}
}
