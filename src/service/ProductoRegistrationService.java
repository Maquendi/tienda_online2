package service;

import dao.compartido.Archivo;
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
		
		Archivo archivoTexto = new Archivo();
		archivoTexto.setNombreArchivo(ARCHIVO_PRODUCTO);
		ProductoSerializer serializar = new ProductoSerializer(producto);
		String productoValor = serializar.serializar();
		archivoTexto.setContenido(productoValor);
		escritor.crear(archivoTexto);
		
		return true;
	}

}
