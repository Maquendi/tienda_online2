package com.tienda.online.dao.file.rol;

import com.tienda.online.dao.file.compartido.Serializador;
import com.tienda.online.dao.modelo.Rol;

public class RolSerializer implements Serializador{

	private final Rol rol;
	
	public RolSerializer(Rol rol) {
		
		this.rol = rol;
	}
	
	
	@Override
	public String serializar() {
		
		final var SEPARATOR = ",";
		
		var rolStringBuilder = new StringBuilder();
		
		return rolStringBuilder
				.append(rol.getId())
				.append(SEPARATOR)
				.append(rol.getNombreRol())
				.toString();
	}

	
}
