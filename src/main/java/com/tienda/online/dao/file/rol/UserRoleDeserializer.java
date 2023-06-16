package com.tienda.online.dao.file.rol;

import com.tienda.online.dao.file.compartido.DeSerializer;
import com.tienda.online.dao.modelo.UserRole;

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
