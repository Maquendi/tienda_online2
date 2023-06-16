package dao.rol;

import dao.compartido.DeSerializer;
import dao.modelo.Rol;

public class RolDeserializer implements DeSerializer{

	@Override
	public Object deSerializar(String linea) {
		
		final String SEPARATOR = ",";
		
		String[] atributosRol = linea.split(SEPARATOR);
		
		Rol rol =new Rol();
		
		rol.setId(atributosRol[0]);
		rol.setNombreRol(atributosRol[1]);
		
		return rol;
		
		
	}

}
