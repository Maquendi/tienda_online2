package dao.cliente;
import dao.compartido.DeSerializer;
import dao.modelo.Cliente;

public class ClienteDeSerializer implements DeSerializer{

	@Override
	public Object deSerializar(String linea) {
		
		final String SEPARATOR = ",";
		
		String[] attributosCliente = linea.split(SEPARATOR);
		
		Cliente cliente = new Cliente();
		
		cliente.setCuentaBancaria(attributosCliente[0]);
		
		return cliente;
		
	}

}
