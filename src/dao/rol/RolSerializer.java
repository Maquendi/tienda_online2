package dao.rol;

import dao.compartido.Serializador;
import dao.modelo.Rol;

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
