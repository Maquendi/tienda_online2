package app;

public class Application {
	
	public static void main(String[] args) {
		
		try {
			CommandLineApplication.init();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
