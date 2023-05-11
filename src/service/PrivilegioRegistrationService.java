package service;

import dao.compartido.Archivo;
import dao.privilegio.*;
import dao.compartido.EscritorDeArchivoDeTexto;
import modelo.Privilegio;

public class PrivilegioRegistrationService {

	private final EscritorDeArchivoDeTexto escritor;
	
	private static final String ARCHIVO_PRIVILEGIO = "archivo_privilegio";
	
	public PrivilegioRegistrationService() {
		
		this.escritor = new EscritorDeArchivoDeTexto();
	}
	
	public boolean crearPrivilegio(Privilegio privilegio) {
		
		Archivo archivoTexto = new Archivo();
		archivoTexto.setNombreArchivo(ARCHIVO_PRIVILEGIO);
		PrivilegioSerializer serializer = new PrivilegioSerializer(privilegio);
		String privilegioValor = serializer.serializar();
		archivoTexto.setContenido(privilegioValor);
		escritor.crear(archivoTexto);
		return true;
	}
}
