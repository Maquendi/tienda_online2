package com.tienda.online.app.cmd.commandline;


import com.tienda.online.dao.modelo.Persona;
import com.tienda.online.exceptions.DataCollectionException;
import com.tienda.online.exceptions.UserDataNotFoundException;
import com.tienda.online.exceptions.UserDataValidationException;
import com.tienda.online.exceptions.UserNotFoundException;
import com.tienda.online.service.user.*;
import com.tienda.online.app.cmd.commandline.menu.Menu;
import com.tienda.online.app.cmd.commandline.menu.MenuItem;
import com.tienda.online.app.cmd.commandline.menu.MenuManager;

import java.util.Optional;
import java.util.Scanner;

public class UserMenuCommandLineService {

	// dto == data transfer object

	private final UserService userService;
	private final MenuManager menuManager;

	public UserMenuCommandLineService(MenuManager menuManager, UserService userService) {
		this.userService = userService;
		this.menuManager = menuManager;
	}

	public void doLogin(Scanner scanner) {

		System.out.print("Usuario: ");

		var nombreUsuario = scanner.nextLine();

		System.out.print("Contrasena: ");

		var contrasena = scanner.nextLine();

		System.out.println(String.format("User > %s, Password > %s", nombreUsuario, contrasena));

		try {
			UserSession user = userService.doLogin(nombreUsuario, contrasena);

			UserSessionService.getInstace().setUser(user);

			if (user.isAdmin()) {
				displayAdminMenu();

			}

		} catch (UserNotFoundException e) {

			System.out.println("Inicio de sesion fallo, intente de nuevo.");

			doLogin(scanner);
			// recursividad...
		} catch (NullPointerException e) {
			System.out.println("Ocurio un error interno, por favor contacte el administrador del sistema.");
		} catch (UserDataNotFoundException e) {
			System.out.println("Tu usuario no esta bien configurado, por favor contacte el administrador del sistema.");
		}
	}

	public void doRegistration(Scanner scanner) {

		try {
			var userDto = PersonaCommandLine.collectUserData(scanner);

			userService.doRegistration(userDto);

		} catch (DataCollectionException e) {
			System.out.print("Registro fallo con error: ".concat(e.getMessage()));
		} catch (UserDataValidationException e) {
			System.out.println("Registro fallo con error: ".concat(e.getMessage()));
		}
	}

	public void recuperarContrasena(Scanner scanner) {

		System.out.println("Introduzca su correo electronico, por favor");

		String email = scanner.nextLine();

		Optional<Persona> personOptional = userService.getUserByEmail(email);

		if (personOptional.isPresent()) {
			recuperarContrasena(scanner, personOptional.get());
		} else {
			System.out.println("No se hallo el correo electronico, intentelo de nuevo por favor");
			recuperarContrasena(scanner);
		}
	}

	private void recuperarContrasena(Scanner scanner, Persona persona) {
		System.out.println("Introduzca una contrasena nueva: ");

		String password1 = scanner.nextLine();

		System.out.println("Confirmar Contrasena: ");

		String password2 = scanner.nextLine();

		if (password1.equals(password2)) {
			try {
				userService.changePassword(persona.getId(), password1, password2);
				System.out.println("Contrasena guardada");
			} catch (UserNotFoundException e) {
				System.out.println(
						"Error al tratar de guardar, contacte al administrador del sistema.: " + e.getMessage());
			} catch (UserDataValidationException e) {
				System.out.println(
						"Error al tratar de guardar, contacte al administrador del sistema.: " + e.getMessage());
			}
		} else {
			System.out.println("La contrasena no coincide, intenta de nuevo");
			recuperarContrasena(scanner, persona);
		}
	}

	public void displayStartMenu() {
		var loginMenu = new Menu("Authenticacion de Usuario");
		loginMenu.addMenuItem(new MenuItem("Iniciar Session", this::doLogin));
		loginMenu.addMenuItem(new MenuItem("Crear Cuenta Nueva", this::doRegistration));
		loginMenu.addMenuItem(new MenuItem("Recuperar mi contrasena", this::recuperarContrasena));
		menuManager.display(loginMenu);
	}

	// event handling, o manejo de eventos.

	// handler, o manejador

	// method reference.

	public void displayAdminMenu() {
		var adminMenu = new Menu("Authenticacion de Usuario");
		adminMenu.addMenuItem(new MenuItem("Administrar Usuarios", this::userAdministration));
		adminMenu.addItemNext(new MenuItem("Administrar Roles", this::rolesAdministration));
		adminMenu.addMenuItem(new MenuItem("Administrar Clientes", this::clientAdministration));
		adminMenu.addMenuItem(new MenuItem("Administrar inventario", this::inventoryAdministration));
		// poner opciones de menu para un admin
		menuManager.display(adminMenu);
	}

	public void displayClientMenu() {
		var adminMenu = new Menu("Authenticacion de Usuario");

		// poner opciones de menu para un client
		menuManager.display(adminMenu);
	}

	public void userAdministration(Scanner scanner) {
		System.out.println("Administrar Usuarios");
		
		// crear y mostrar menu para administrar usuarios.
		// 1; asignar roles
		// 2; crear un usuario
		// 3; eliminar usuario,
		// 4; etc..
	}

	public void rolesAdministration(Scanner scanner) {
		System.out.println("Administrar Roles");
	}

	public void clientAdministration(Scanner scanner) {
		System.out.println("Administrar Clientes");

	}

	public void inventoryAdministration(Scanner scanner) {
		System.out.println("Administrar Inventario");

	}
}
