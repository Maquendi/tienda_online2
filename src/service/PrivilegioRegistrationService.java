package service;

import dao.compartido.Archivo;
import dao.privilegio.*;
import dao.rol.RolSerializer;
import dao.compartido.EscritorDeArchivoDeTexto;
import dao.compartido.Serializador;
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
        Serializador serializer = new PrivilegioSerializer(privilegio);
		serializer.serializar();
		String privilegioValor = serializer.serializar();
		
		
		
		archivoTexto.setContenido(privilegioValor);
		escritor.crear(archivoTexto);
		return true;
	}
}
