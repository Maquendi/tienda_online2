package service;

import dao.compartido.Archivo;

import dao.privilegio.*;
import dao.rol.RolSerializer;
import dao.compartido.EscritorDeArchivoDeTexto;
import dao.compartido.Serializador;
import modelo.Privilegio;
import modelo.Rol;
import dao.rol.*;

public class PrivilegioRegistrationService {

	private final EscritorDeArchivoDeTexto escritor;
	
	private static final String ARCHIVO_PRIVILEGIO = "archivo_privilegio";
	
	private static final String ARCHIVO_ROL = "archivo_rol";
	
	public PrivilegioRegistrationService() {
		
		this.escritor = new EscritorDeArchivoDeTexto();
	}
	
	public boolean crearPrivilegio(Privilegio privilegio) {
		
		Archivo archivoTexto = new Archivo();
		archivoTexto.setNombreArchivo(ARCHIVO_PRIVILEGIO);
        Serializador serializer = new PrivilegioSerializer(privilegio);
		serializer.serializar();
		String privilegioValor = serializer.serializar();
		
		
		
		archivoTexto.setContenido(privilegioValor);
		escritor.crear(archivoTexto);
		return true;
	}
	
	public boolean crearRol(Rol rol) {
		Archivo archivoTexto = new Archivo();
		archivoTexto.setNombreArchivo(ARCHIVO_ROL);
		RolSerializer serializer = new RolSerializer(rol);
		String rolValor = serializer.serializar();
		archivoTexto.setContenido(rolValor);
		escritor.crear(archivoTexto);
		return true;
	}
}
