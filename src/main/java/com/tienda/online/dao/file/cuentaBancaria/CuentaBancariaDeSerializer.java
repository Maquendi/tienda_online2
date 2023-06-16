package com.tienda.online.dao.file.cuentaBancaria;


import com.tienda.online.dao.file.compartido.DeSerializer;
import com.tienda.online.dao.modelo.Cliente;
import com.tienda.online.dao.modelo.CuentaBancaria;

public class CuentaBancariaDeSerializer implements DeSerializer {

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
