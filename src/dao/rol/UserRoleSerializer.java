package dao.rol;

import dao.compartido.Serializador;
import modelo.UserRole;

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
