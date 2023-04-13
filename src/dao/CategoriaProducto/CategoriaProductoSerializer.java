package dao.CategoriaProducto;

import dao.compartido.Serializador;
import modelo.CategoriaProducto;

public class CategoriaProductoSerializer implements Serializador{

	private final CategoriaProducto categoriaProducto;
	
	public CategoriaProductoSerializer(CategoriaProducto categoriaProducto) {
		
		this.categoriaProducto=categoriaProducto;
	}
	
	@Override
	public String serializar() {
		
		final var SEPARATOR = ",";
		
		var CategoriaProductoStringBuilder = new StringBuilder();
		
		return CategoriaProductoStringBuilder
				.append(categoriaProducto.getId())
				.append(categoriaProducto.getNombreDeCategoria())
				.toString();
	}

}
