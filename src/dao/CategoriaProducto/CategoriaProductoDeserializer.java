package dao.CategoriaProducto;

import dao.compartido.DeSerializer;
import modelo.CategoriaProducto;

public class CategoriaProductoDeserializer implements DeSerializer{

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
