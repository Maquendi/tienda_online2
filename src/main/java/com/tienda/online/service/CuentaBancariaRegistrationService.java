package com.tienda.online.service;


import com.tienda.online.dao.file.compartido.EscritorDeArchivoDeTexto;
import com.tienda.online.dao.file.compartido.Linea;
import com.tienda.online.dao.file.cuentaBancaria.CuentaBancariaSerializer;
import com.tienda.online.dao.modelo.CuentaBancaria;

public class CuentaBancariaRegistrationService {

    private final EscritorDeArchivoDeTexto escritor;
	
	private static final String ARCHIVO_CUENTA_BANCARIA = "archivo_cuenta_bancaria";

	public CuentaBancariaRegistrationService() {
		this.escritor = new EscritorDeArchivoDeTexto();
	}
	
	public boolean crearCuentaBancaria(CuentaBancaria cuentaBancaria) {
		Linea archivoTexto = new Linea();
		CuentaBancariaSerializer serializer = new CuentaBancariaSerializer(cuentaBancaria);
		String cuentaBancariaValor = serializer.serializar();
		archivoTexto.setContenido(cuentaBancariaValor);
		escritor.escribir(ARCHIVO_CUENTA_BANCARIA, archivoTexto);
		return true;
		
	}

}
