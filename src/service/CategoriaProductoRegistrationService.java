package service;

import dao.CategoriaProducto.CategoriaProductoSerializer;
import dao.compartido.Linea;
import dao.modelo.CategoriaProducto;
import dao.compartido.EscritorDeArchivoDeTexto;
import dao.usuario.UsuarioSerializer;

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
