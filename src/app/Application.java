package app;

import java.util.Scanner;
import app.commandline.UserCommandLineService;
import app.commandline.menu.MenuManager;
import service.user.DefaultUserServiceImpl;

public class Application {

	public static void main(String[] args) {

		try {
			// CommandLineApplication.init();

			var menuManager = new MenuManager(new Scanner(System.in));
			
			var userService = new DefaultUserServiceImpl();
			
			var userCommandLineService = new UserCommandLineService(menuManager, userService);
			
			userCommandLineService.displayMenu();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
