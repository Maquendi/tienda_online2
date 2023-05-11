package service;

import modelo.*;
import dao.rol.*;
import dao.compartido.*;

public class RolRegistrationService {

	private final EscritorDeArchivoDeTexto escritor;
	
	private static final String ARCHIVO_ROLES = "archivo_roles";
	
	public RolRegistrationService() {
		this.escritor = new EscritorDeArchivoDeTexto();
	}
	
	public boolean crearRol(Rol rol) {
		Archivo archivoTexto = new Archivo(); 
		archivoTexto.setNombreArchivo(ARCHIVO_ROLES);
		RolSerializer serializer = new RolSerializer(rol);
		String rolValor = serializer.serializar();
		archivoTexto.setContenido(rolValor);
		escritor.crear(archivoTexto);
		return true;
		
	}
}
