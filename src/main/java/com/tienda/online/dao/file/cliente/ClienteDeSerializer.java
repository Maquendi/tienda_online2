package com.tienda.online.dao.file.cliente;
import com.tienda.online.dao.file.compartido.DeSerializer;
import com.tienda.online.dao.modelo.Cliente;

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
