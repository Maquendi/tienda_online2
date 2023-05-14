package app.commandline.menu;

import java.util.Scanner;

// pojo --> plain old java object

public class MenuItem {
	
	private int option;
	
	private String text;
	
	private final MenuItemHandler onSelectedHandler;

	public MenuItem(String text, MenuItemHandler onSelectedHandler) {
		this.text = text;
		this.onSelectedHandler=onSelectedHandler;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

	public void callOnSelectedHandler(Scanner scanner) {
		onSelectedHandler.handle(scanner);
	}
}
