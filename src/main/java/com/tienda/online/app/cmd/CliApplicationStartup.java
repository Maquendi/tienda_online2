package com.tienda.online.app.cmd;

import com.tienda.online.dao.file.user.FileUserServiceDao;
import com.tienda.online.service.user.DefaultUserServiceImpl;
import com.tienda.online.app.cmd.commandline.UserMenuCommandLineService;
import com.tienda.online.app.cmd.commandline.menu.MenuManager;

import java.util.Scanner;



public class CliApplicationStartup {

	public void onStart() {
		try {
			var menuManager = new MenuManager(new Scanner(System.in));

			var userService = new DefaultUserServiceImpl(new FileUserServiceDao());
			
			var userMenuCommandLineService = new UserMenuCommandLineService(menuManager, userService);
			
			userMenuCommandLineService.displayStartMenu();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
