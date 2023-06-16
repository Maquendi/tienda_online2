package com.tienda.online.service;


import com.tienda.online.dao.file.compartido.EscritorDeArchivoDeTexto;
import com.tienda.online.dao.file.compartido.Linea;
import com.tienda.online.dao.file.compartido.Serializador;
import com.tienda.online.dao.modelo.Privilegio;
import com.tienda.online.dao.modelo.Rol;
import com.tienda.online.dao.file.privilegio.PrivilegioSerializer;
import com.tienda.online.dao.file.rol.RolSerializer;

public class PrivilegioRegistrationService {

	private final EscritorDeArchivoDeTexto escritor;
	
	private static final String ARCHIVO_PRIVILEGIO = "archivo_privilegio";
	
	private static final String ARCHIVO_ROL = "archivo_rol";
	
	public PrivilegioRegistrationService() {
		
		this.escritor = new EscritorDeArchivoDeTexto();
	}
	
	public boolean crearPrivilegio(Privilegio privilegio) {
		
		Linea archivoTexto = new Linea();
        Serializador serializer = new PrivilegioSerializer(privilegio);
		serializer.serializar();
		String privilegioValor = serializer.serializar();
		
		
		
		archivoTexto.setContenido(privilegioValor);
		escritor.escribir(ARCHIVO_PRIVILEGIO,archivoTexto);
		return true;
	}
	
	public boolean crearRol(Rol rol) {
		Linea archivoTexto = new Linea();
		RolSerializer serializer = new RolSerializer(rol);
		String rolValor = serializer.serializar();
		archivoTexto.setContenido(rolValor);
		escritor.escribir(ARCHIVO_ROL, archivoTexto);
		return true;
	}
}
