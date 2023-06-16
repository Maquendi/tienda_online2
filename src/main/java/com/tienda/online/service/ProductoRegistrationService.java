package com.tienda.online.service;


import com.tienda.online.dao.file.compartido.EscritorDeArchivoDeTexto;
import com.tienda.online.dao.file.compartido.Linea;
import com.tienda.online.dao.modelo.Producto;
import com.tienda.online.dao.file.producto.ProductoSerializer;

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
