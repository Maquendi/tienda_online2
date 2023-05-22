package app.commandline.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuManager {

	private final List<Menu> menus = new ArrayList<>();

	private int currentMenuIndex;

	private final Scanner scanner;

	public MenuManager(Scanner scanner) {
		this.scanner = scanner;
	}

	private void showNext() {
		if (hasNext()) {
			currentMenuIndex += 1;
			displayCurrentMenu();
		}
	}

	private void showPrevious() {
		if (hasPrevious()) {
			currentMenuIndex -= 1;
			var menu = menus.get(currentMenuIndex);
			menu.addItemNext(new MenuItem("Next", this.onNextSelected()));
			displayCurrentMenu();
		}
	}

	private void displayCurrentMenu() {

		Menu menu = menus.get(currentMenuIndex);

		try {
			Runtime.getRuntime().exec("cls");
		} catch (Exception e) {

		}

		String genericDescriptionStart = "\n********************** Compra con nosotros *************************\n\n";
		System.out.print(genericDescriptionStart);
		// display menuItems here..
		menu.displayItems();
		String genericDescriptionEnd = "\n\n********************** Todos los derechos resevados *************************\n\n";
		System.out.print(genericDescriptionEnd);

		getAndValidateSelectedOption(menu);
	}

	private void getAndValidateSelectedOption(Menu menu) {

		String selectedOption;
		try {
			System.out.print("\nSeleccionar: ");

			selectedOption = scanner.nextLine();

			int option = Integer.valueOf(selectedOption);

			int menuItemCount = menu.getMenuItems().size();

			boolean optionNotValidated = option < 0 || option > menuItemCount;

			if (optionNotValidated) {
				// some message
				System.out.println("\nOpcion no habilitado. \n\n");
				getAndValidateSelectedOption(menu);
			}

			onMenuItemSelected(option);

		} catch (NumberFormatException ex) {
			System.out.println("\nOpcion invalido. \n\n");
			getAndValidateSelectedOption(menu);
		}
	}

	private void onMenuItemSelected(int option) {
		menus.get(currentMenuIndex).getItem(option).ifPresent(menuItem -> menuItem.callOnSelectedHandler(scanner));
	}

	private boolean isFirstMenuItem(MenuItem menuItem) {
		var currentMenu = menus.get(currentMenuIndex);
		return menuItem.getOption() == currentMenu.getFirstItem().getOption();
	}

	private boolean isLastMenuItem(MenuItem menuItem) {
		var currentMenu = menus.get(currentMenuIndex);
		return menuItem.getOption() == currentMenu.getLastItem().getOption();
	}

	private boolean hasNext() {
		var lastMenuIndex = menus.size() - 1;
		return currentMenuIndex < lastMenuIndex;
	}

	private boolean hasPrevious() {
		return currentMenuIndex > 0;
	}

	private MenuItemHandler onPreviousSelected() {
		return (scanner) -> {
			this.showPrevious();
		};
	}

	private MenuItemHandler onNextSelected() {
		return (scanner) -> {
			this.showNext();
		};
	}

	
	// mostrar....
	public void display(Menu menu) {
		this.addMenu(menu);
		displayCurrentMenu();
	}

	
	// make this itempotent
	private void addMenu(Menu menu) {
		    //               0  1  2  3
            // indice/index [41,58,96,13]
		this.menus.add(menu);
		currentMenuIndex = menus.size() - 1;
		
		if (hasPrevious()) {
			menu.addMenuItemBefore(new MenuItem("Previous", this.onPreviousSelected()));
		}
		
		menu.addMenuItem(new MenuItem("Salir", this::salir));
	}
	
	
	private void salir(Scanner scanner) {
		//
		System.out.println("Saliendo del sistema ....");
		System.exit(0);
	}
}
