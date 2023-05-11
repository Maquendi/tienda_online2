package dao.producto;
import dao.compartido.Serializador;

import modelo.Producto;

public class ProductoSerializer implements Serializador {

	public final Producto producto;
	
	public ProductoSerializer(Producto producto) {
		
		this.producto = producto;
	}
	
	@Override
	public String serializar() {
		
		final var SEPARATOR = " , ";
		
		var productStringBuilder = new StringBuilder();
		
		return productStringBuilder
				.append(producto.getId())
				.append(SEPARATOR)
				.append(producto.getDescripcion())
				.append(SEPARATOR)
				.append(producto.getCategoria().getId())
				.toString();
				
	
	}
}
