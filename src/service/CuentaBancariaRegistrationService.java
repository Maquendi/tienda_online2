package service;

import dao.compartido.Linea;
import dao.compartido.EscritorDeArchivoDeTexto;
import modelo.CuentaBancaria;
import dao.cuentaBancaria.*;

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
