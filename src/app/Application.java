package app;

import java.util.Scanner;

import app.commandline.UserMenuCommandLineService;
import app.commandline.menu.MenuManager;
import dao.user.TextFileUserServiceDao;
import service.user.DefaultUserServiceImpl;

public class Application {

	public static void main(String[] args) {

		try {
			var menuManager = new MenuManager(new Scanner(System.in));

			var userService = new DefaultUserServiceImpl(new TextFileUserServiceDao());
			
			var userMenuCommandLineService = new UserMenuCommandLineService(menuManager, userService);
			
			userMenuCommandLineService.displayStartMenu();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
