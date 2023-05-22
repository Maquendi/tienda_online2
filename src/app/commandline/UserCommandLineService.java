package app.commandline;

import java.util.Scanner;

import app.commandline.menu.Menu;
import app.commandline.menu.MenuItem;
import app.commandline.menu.MenuManager;
import service.user.UserDataNotFoundException;
import service.user.UserNotFoundException;
import service.user.UserService;
import service.user.UserSession;

public class UserCommandLineService {
	
	private final UserService userService;
	private final MenuManager menuManager;
	
	public UserCommandLineService(
			MenuManager menuManager,
			UserService userService) {
		this.userService=userService;
		this.menuManager=menuManager;
	}
	
	public void doLogin(Scanner scanner) {	
		
		System.out.print("Usuario: ");
		
		var nombreUsuario = scanner.nextLine();
		
		System.out.print("Contrasena: ");
		
		var contrasena = scanner.nextLine();
		
		System.out.println(String.format("User > %s, Password > %s", nombreUsuario, contrasena));
		
		try {
			UserSession user = userService.doLogin(nombreUsuario, contrasena);
			
			
			
		} catch (UserNotFoundException e) {
			
			System.out.println("Inicio de sesion fallo, intente de nuevo.");
			
			doLogin(scanner);
			// recursividad...
		}catch(NullPointerException e) {
			System.out.println("Ocurio un error interno, por favor contacte el administrador del sistema.");
		}catch(UserDataNotFoundException e) {
			System.out.println("Tu usuario no esta bien configurado, por favor contacte el administrador del sistema.");
		}
	}

	
	public void doRegistration(Scanner scanner) {
		System.out.println("You selected Register");
		

	
		userService.doRegistration();
	}
	
	public void recuperarContrasena(Scanner scanner) {
		System.out.println("You selected Register");
		

	
		userService.doRegistration();
	}
	
	public void displayMenu() {
		var loginMenu = new Menu("Authenticacion de Usuario");
		loginMenu.addMenuItem(new MenuItem("Iniciar Session", this::doLogin));
		loginMenu.addMenuItem(new MenuItem("Crear Cuenta Nueva", this::doRegistration));
		loginMenu.addMenuItem(new MenuItem("Recuperar mi contrasena", this::recuperarContrasena));
		menuManager.display(loginMenu);
		// mostrar
	}
	
	public void displayAdminMenu() {
		var adminMenu = new Menu("Authenticacion de Usuario");
		
		// poner opciones de menu para un admin
		menuManager.display(adminMenu);
	}
	
	public void displayClientMenu() {
		var adminMenu = new Menu("Authenticacion de Usuario");
		
		// poner opciones de menu para un client
		menuManager.display(adminMenu);
	}
}
