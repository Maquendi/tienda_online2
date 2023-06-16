package com.tienda.online.dao.file.CategoriaProducto;


import com.tienda.online.dao.file.compartido.Serializador;
import com.tienda.online.dao.modelo.CategoriaProducto;

public class CategoriaProductoSerializer implements Serializador {

	private final CategoriaProducto categoriaProducto;
	
	public CategoriaProductoSerializer(CategoriaProducto categoriaProducto) {
		
		this.categoriaProducto=categoriaProducto;
	}
	
	@Override
	public String serializar() {
		
		final var SEPARATOR = ",";
		
		var categoriaProductoStringBuilder = new StringBuilder();
		
		return categoriaProductoStringBuilder
				.append(categoriaProducto.getId())
				.append(SEPARATOR)
				.append(categoriaProducto.getNombreDeCategoria())
				.toString();
	}

}
