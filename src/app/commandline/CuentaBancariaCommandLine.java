package app.commandline;

import java.util.Scanner;
import modelo.CuentaBancaria;
import modelo.Cliente;
import service.CuentaBancariaRegistrationService;

public class CuentaBancariaCommandLine {

	public static void registrar(Scanner scanner) {
		
		System.out.print("Nombre banco: ");
		
		String nombreBanco = scanner.nextLine();
		
		System.out.print("Tipo de cuenta: ");
		
		String tipoCuenta = scanner.nextLine();
		
		System.out.print("Id cliente: ");
		
		String clienteId = scanner.nextLine();
		
		CuentaBancaria cuentaBancaria = new CuentaBancaria();
		
		Cliente cliente = new Cliente();
		
		cliente.setId(clienteId);
		
		cuentaBancaria.setNombreBanco(nombreBanco);
		
		cuentaBancaria.setTipoCuenta(tipoCuenta);
		
		CuentaBancariaRegistrationService registrationService = new CuentaBancariaRegistrationService();
		
		registrationService.crearCuentaBancaria(cuentaBancaria);
		
		System.out.println("Ya se ha creado una nueva Cuenta Bancaria.");
		
	}
}
