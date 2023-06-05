package service;

import dao.compartido.Linea;
import dao.compartido.EscritorDeArchivoDeTexto;
import modelo.Producto;
import dao.producto.*;

public class ProductoRegistrationService {

	private final EscritorDeArchivoDeTexto escritor;
	
	private static final String ARCHIVO_PRODUCTO= "archivo_producto";
	
	public ProductoRegistrationService() {
		this.escritor=new EscritorDeArchivoDeTexto();
	}
	
	public boolean crearProducto(Producto producto) {
		
		Linea archivoTexto = new Linea();
		ProductoSerializer serializar = new ProductoSerializer(producto);
		String productoValor = serializar.serializar();
		archivoTexto.setContenido(productoValor);
		escritor.escribir(ARCHIVO_PRODUCTO,archivoTexto);
		
		return true;
	}

}
