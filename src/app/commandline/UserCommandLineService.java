package app.commandline;

import java.util.Scanner;

import app.commandline.menu.Menu;
import app.commandline.menu.MenuItem;
import app.commandline.menu.MenuManager;
import service.user.UserService;

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
		System.out.println("You selected Login");
		
		// collect user info here
		
		// validate the user data
		
		// try to do login
		
		// if not successfull throw
		
		var menu = new Menu();
		
		menu.addMenuItem(new MenuItem("Admin login", (s)-> System.out.println("Admin Login selected")));
		
		menu.addMenuItem(new MenuItem("Merchant login", (s)-> System.out.println("Merchant Login selected")));
		
		menu.addMenuItem(new MenuItem("Client login", (s)-> System.out.println("Client Login selected")));
		
		
		//
		
		menuManager.display(menu);
		
		//userService.doLogin();
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
}
