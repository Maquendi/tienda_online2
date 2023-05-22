package dao.rol;

import dao.compartido.DeSerializer;
import modelo.UserRole;

public class UserRoleDeserializer implements DeSerializer {

	@Override
	public Object deSerializar(String linea) {
		final String SEPARATOR = ",";
		
		String[] atributosRol = linea.split(SEPARATOR);
		
		UserRole rol =new UserRole();
		
		rol.setUserId(atributosRol[0]);
		rol.setRoleId(atributosRol[1]);
		
		return rol;
	}

}
