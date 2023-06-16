package com.tienda.online.service;


import com.tienda.online.dao.file.CategoriaProducto.CategoriaProductoSerializer;
import com.tienda.online.dao.file.compartido.EscritorDeArchivoDeTexto;
import com.tienda.online.dao.file.compartido.Linea;
import com.tienda.online.dao.modelo.CategoriaProducto;

public class CategoriaProductoRegistrationService {

	private final EscritorDeArchivoDeTexto escritor;
	
	private static final String ARCHIVO_CATEGORIA_PRODUCTO="archivo_categoria_producto";
	
	public CategoriaProductoRegistrationService(){
		this.escritor = new EscritorDeArchivoDeTexto();
	}
	
	public boolean crearCategoriaProducto(CategoriaProducto categoriaProducto) {
		Linea archivoTexto = new Linea();
		CategoriaProductoSerializer serializer = new CategoriaProductoSerializer(categoriaProducto);
		String categoriaProductoValor = serializer.serializar();
		archivoTexto.setContenido(categoriaProductoValor);
		escritor.escribir(ARCHIVO_CATEGORIA_PRODUCTO, archivoTexto);
		return true;
	}
}
