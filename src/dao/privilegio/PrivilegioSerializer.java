package dao.privilegio;
import modelo.Privilegio;
import dao.compartido.Serializador;

public class PrivilegioSerializer implements Serializador{

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
