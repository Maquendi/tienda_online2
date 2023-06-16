package com.tienda.online.dao.file.cliente;

import com.tienda.online.dao.file.compartido.Serializador;
import com.tienda.online.dao.modelo.Cliente;


public class ClienteSerializer implements Serializador{

	private final Cliente cliente;
	
	public ClienteSerializer(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public String serializar() {
		
		final var SEPARATOR = ",";
		
		var clienteStringBuilder = new StringBuilder();
		
		return clienteStringBuilder
				.append(cliente.getId())
				.append(SEPARATOR)
				.append(cliente.getCuentaBancaria())
				.toString();
	}

}
