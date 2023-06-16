package dao.privilegio;
import dao.compartido.DeSerializer;
import dao.modelo.Privilegio;

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
