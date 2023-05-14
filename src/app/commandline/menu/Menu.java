package app.commandline.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Menu {

	private Optional<String> description;

	private List<MenuItem> menuItems; 
	
	private boolean nextAdded;

	private boolean previousAdded;

	public Menu(String description) {
		this.description = Optional.ofNullable(description);
		menuItems = new ArrayList<>();
	}

	public Menu() {
		menuItems = new ArrayList<>();
		this.description = Optional.empty();
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public Menu addMenuItem(MenuItem menuItem) {
		this.menuItems.add(menuItem);
		menuItem.setOption(menuItems.size());
		return this;
	}

	public void addItemNext(MenuItem menuItem) {
		if (!nextAdded) {
			this.addMenuItem(menuItem);
			this.nextAdded = true;
		}
	}

	public Optional<String> getDescription() {
		return this.description;
	}

	public void addMenuItemBefore(MenuItem menuItem) {
		if (!previousAdded) {
			var temp = menuItems;
			menuItems = new ArrayList<MenuItem>();
			this.addMenuItem(menuItem);
			temp.forEach(this::addMenuItem);
			this.previousAdded = true;
		}
	}

	public MenuItem getLastItem() {
		return this.menuItems.get(menuItems.size() - 1);
	}

	public MenuItem getFirstItem() {
		return this.menuItems.get(0);
	}

	public Optional<MenuItem> getItem(int option) {
		return menuItems.stream().filter(item -> item.getOption() == option).findFirst();
	}

	public void displayItems() {
		this.getMenuItems().forEach(this::display);
	}

	private void display(MenuItem menuItem) {
		System.out.println(String.format(" #%s %s", menuItem.getOption(), menuItem.getText()));
	}

}
