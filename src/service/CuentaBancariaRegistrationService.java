package service;

import dao.compartido.Archivo;
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
		Archivo archivoTexto = new Archivo();
		archivoTexto.setNombreArchivo(ARCHIVO_CUENTA_BANCARIA);
		CuentaBancariaSerializer serializer = new CuentaBancariaSerializer(cuentaBancaria);
		String cuentaBancariaValor = serializer.serializar();
		archivoTexto.setContenido(cuentaBancariaValor);
		escritor.crear(archivoTexto);
		return true;
		
	}

}
