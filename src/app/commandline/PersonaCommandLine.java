package app.commandline;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import dao.modelo.CategoriaProducto;
import dao.modelo.Cliente;
import dao.modelo.CuentaBancaria;
import dao.modelo.Usuario;
import enums.Sexo;
import dao.modelo.Persona;
import service.CategoriaProductoRegistrationService;
import service.CuentaBancariaRegistrationService;
import service.UserRegistrationService;
import service.dto.UserDto;
import service.user.DataCollectionException;

public class PersonaCommandLine {

	public static UserDto collectPersonalInfo(Scanner scanner) throws DataCollectionException{

		System.out.print("Nombre: ");

		String nombre = scanner.nextLine();

		System.out.print("Appellido Paterno: ");

		String appelidoPaterno = scanner.nextLine();

		System.out.print("Appellido Materno: ");

		String appelidoMaterno = scanner.nextLine();

		System.out.print("Correo electronico: ");

		String correo = scanner.nextLine();

		System.out.print("Genero: ");

		String genero = scanner.nextLine();

		System.out.print("Fecha Nacimiento (año,mes,dia): ");
		
		String fechaNacimeinto = scanner.nextLine();
			
		UserDto personalInfo = new UserDto();
		
		try {
			personalInfo.setName(nombre);
			personalInfo.setMyFirstLastname(appelidoPaterno);
			personalInfo.setMySecondLastname(appelidoMaterno);
			personalInfo.setEmailAdress(correo);
			personalInfo.setSex(genero);
			String[] datosDeNacimiento = fechaNacimeinto.split(",");
			int ano = Integer.valueOf(datosDeNacimiento[0]);
			int mes = Integer.valueOf(datosDeNacimiento[1]);
			int dia = Integer.valueOf(datosDeNacimiento[2]);
			
			LocalDate fechaDeNacimiento = LocalDate.of(ano, mes, dia);
			personalInfo.setMyDateOfBirth(fechaDeNacimiento);
			
			System.out.print("Usuario: ");

			String userName = scanner.nextLine();

			System.out.print("Contraseña: ");

			String passWord = scanner.nextLine();

			personalInfo.setUserName(userName);

			personalInfo.setPassword(passWord);

			return personalInfo;
			
		} catch (NumberFormatException e) {
			throw new DataCollectionException("El formato de la fecha de nacimiento no es valido.");
		} catch (IndexOutOfBoundsException e) {
			throw new DataCollectionException("El formato de la fecha de nacimiento no es valido.");
		}catch(DateTimeException e) {
			throw new DataCollectionException("El formato de la fecha de nacimiento no es valido.");
		}
	}
}
