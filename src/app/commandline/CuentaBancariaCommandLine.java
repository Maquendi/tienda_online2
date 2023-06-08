package app.commandline;

import java.util.Scanner;

import dao.modelo.Cliente;
import dao.modelo.CuentaBancaria;
import service.CuentaBancariaRegistrationService;

public class CuentaBancariaCommandLine {

	public static void registrar(Scanner scanner) {
		
		System.out.print("Nombre del banco: ");
		
		String nombreBanco = scanner.nextLine();
		
		System.out.print("Tipo de cuenta: ");
		
		String tipoCuenta = scanner.nextLine();
		
		CuentaBancaria cuentaBancaria = new CuentaBancaria();
		
		Cliente cliente = new Cliente();
		
		String id = cliente.getId();
		
		cuentaBancaria.setNombreBanco(nombreBanco);
		
		cuentaBancaria.setTipoCuenta(tipoCuenta);
		
		CuentaBancariaRegistrationService registrationService = new CuentaBancariaRegistrationService();
		
		registrationService.crearCuentaBancaria(cuentaBancaria);
		
		System.out.println("Ya se ha registrado una nueva cuenta bancaria.");
		
	}
}
