package dao.cuentaBancaria;

import dao.compartido.Serializador;
import dao.modelo.CuentaBancaria;

public class CuentaBancariaSerializer implements Serializador {

	private final CuentaBancaria cuentaBancaria;
	
	public CuentaBancariaSerializer(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
	
	@Override
	public String serializar() {
		
		final var SEPARATOR = ",";
		
		var cuentaBancariaStringBuilder = new StringBuilder();
		
		return cuentaBancariaStringBuilder
				.append(cuentaBancaria.getClienteId())
				.append(SEPARATOR)
				.append(cuentaBancaria.getNombreBanco())
				.append(SEPARATOR)
				.append(cuentaBancaria.getTipoCuenta())
				.append(SEPARATOR)
				.append(cuentaBancaria.getNumDeCuenta())
				.toString();
		
	}

}
