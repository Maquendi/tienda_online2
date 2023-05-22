package service.user;

public interface UserService {
	
	UserSession doLogin(String nombreUsuario, String contrasena) throws UserNotFoundException, UserDataNotFoundException;
	
	void doRegistration();
}
