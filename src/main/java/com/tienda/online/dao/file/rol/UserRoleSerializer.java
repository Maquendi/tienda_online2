package com.tienda.online.dao.file.rol;

import com.tienda.online.dao.file.compartido.Serializador;
import com.tienda.online.dao.modelo.UserRole;

public class UserRoleSerializer implements Serializador {
	private final UserRole userRole;
	
	public UserRoleSerializer(UserRole userRole) {
		
		this.userRole = userRole;
	}
	
	@Override
	public String serializar() {
		final var SEPARATOR = ",";
		
		var rolStringBuilder = new StringBuilder();
		
		return rolStringBuilder
				.append(userRole.getUserId())
				.append(SEPARATOR)
				.append(userRole.getRoleId())
				.toString();
	}

}
