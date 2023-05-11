package dao.privilegio;
import modelo.Privilegio;
import dao.compartido.DeSerializer;

public class PrivilegioDeSerializer implements DeSerializer{

	@Override
	public Object deSerializar(String linea) {
		
		final String SEPARATOR = ",";
		
		String[] attributosPrivilegio = linea.split(SEPARATOR);
		
		Privilegio privilegio = new Privilegio();
		
		privilegio.setId(attributosPrivilegio[0]);
		privilegio.setNombrePrivilegio(attributosPrivilegio[1]);
		
		return privilegio;
	}

	
}
