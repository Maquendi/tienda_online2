package dao.cuentaBancaria;

import dao.compartido.DeSerializer;
import modelo.CuentaBancaria;
import modelo.Cliente;

public class CuentaBancariaDeSerializer implements DeSerializer{

	@Override
	public Object deSerializar(String linea) {
		
		final String SEPARATOR = ",";
		
		String[] atributosCuentaBancaria = linea.split(SEPARATOR);
		
		CuentaBancaria cuentaBancaria = new CuentaBancaria();
		
		Cliente cliente = new Cliente();
		
		cliente.setId(atributosCuentaBancaria[0]);
		cuentaBancaria.setNombreBanco(atributosCuentaBancaria[1]);
		cuentaBancaria.setTipoCuenta(atributosCuentaBancaria[2]);
		cuentaBancaria.setNumDeCuenta(atributosCuentaBancaria[3]);
		
		return cuentaBancaria;
		
	}

}
