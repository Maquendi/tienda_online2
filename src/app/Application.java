package app;

import java.util.Scanner;
import app.commandline.UserMenuCommandLineService;
import app.commandline.menu.MenuManager;
import dao.compartido.EscritorDeArchivo;
import dao.compartido.EscritorDeArchivoDeTexto;
import dao.compartido.LectorDeArchivo;
import dao.compartido.LectorDeArchivoDeTexto;
import service.UserRegistrationService;
import service.user.DefaultUserServiceImpl;

public class Application {

	public static void main(String[] args) {

		try {
			// CommandLineApplication.init();

			var menuManager = new MenuManager(new Scanner(System.in));
			
			// LectorDeArchivoWord
			
			LectorDeArchivo fileReader = new LectorDeArchivoDeTexto();
			EscritorDeArchivo fileWriter = new EscritorDeArchivoDeTexto();
			UserRegistrationService registrationService = new UserRegistrationService();
			
			var userService = new DefaultUserServiceImpl(fileReader,fileWriter, registrationService);
			
			var userCommandLineService = new UserMenuCommandLineService(menuManager, userService);
			
			userCommandLineService.displayStartMenu();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
