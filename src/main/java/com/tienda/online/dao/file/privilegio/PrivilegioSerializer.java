package com.tienda.online.dao.file.privilegio;


import com.tienda.online.dao.file.compartido.Serializador;
import com.tienda.online.dao.modelo.Privilegio;

// implementacion
public class PrivilegioSerializer implements Serializador {

	private final Privilegio privilegio;
	
	public PrivilegioSerializer(Privilegio privilegio) {
		this.privilegio = privilegio;
	}
	
	@Override
	public String serializar() {
		
		final var SEPARATOR = ",";
		
		var privilegioStringBuilder = new StringBuilder();
		
		return privilegioStringBuilder
				.append(privilegio.getId())
				.append(SEPARATOR)
				.append(privilegio.getNombrePrivilegio())
				.toString();
		
	}

}
