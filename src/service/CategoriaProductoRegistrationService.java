package service;

import dao.CategoriaProducto.CategoriaProductoSerializer;
import dao.compartido.Archivo;
import dao.compartido.EscritorDeArchivoDeTexto;
import dao.usuario.UsuarioSerializer;
import modelo.CategoriaProducto;

public class CategoriaProductoRegistrationService {

	private final EscritorDeArchivoDeTexto escritor;
	
	private static final String ARCHIVO_CATEGORIA_PRODUCTO="archivo_categoria_producto";
	
	public CategoriaProductoRegistrationService(){
		this.escritor = new EscritorDeArchivoDeTexto();
	}
	
	public boolean crearCategoriaProducto(CategoriaProducto categoriaProducto) {
		Archivo archivoTexto = new Archivo();
		archivoTexto.setNombreArchivo(ARCHIVO_CATEGORIA_PRODUCTO);
		CategoriaProductoSerializer serializer = new CategoriaProductoSerializer(categoriaProducto);
		String categoriaProductoValor = serializer.serializar();
		archivoTexto.setContenido(categoriaProductoValor);
		escritor.crear(archivoTexto);
		return true;
	}
}
