package com.tienda.online.dao.file.CategoriaProducto;


import com.tienda.online.dao.file.compartido.DeSerializer;
import com.tienda.online.dao.modelo.CategoriaProducto;

public class CategoriaProductoDeserializer implements DeSerializer {

	@Override
	public Object deSerializar(String linea) {
		
		final String SEPARATOR = ",";
		
		String[] attributosCategoriaProducto = linea.split(SEPARATOR);
		
		CategoriaProducto categoriaProducto = new CategoriaProducto();
		
		categoriaProducto.setId(attributosCategoriaProducto[0]);
		categoriaProducto.setNombreDeCategoria(attributosCategoriaProducto[1]);
		
		return categoriaProducto;
	}

}
