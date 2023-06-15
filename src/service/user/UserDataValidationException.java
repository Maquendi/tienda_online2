package service.user;

public class UserDataValidationException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDataValidationException() {
		super();
	}
	
	public UserDataValidationException(String msg) {
		super(msg);
	}
}
