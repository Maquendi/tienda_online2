package service.user;

import java.util.Optional;

import modelo.Persona;

public interface UserService {
	
	UserSession doLogin(String nombreUsuario, String contrasena) throws UserNotFoundException, UserDataNotFoundException;
	
	void doRegistration();
	
	Optional<Persona> getUserByEmail(String email);

	void changePassword(String userId, String password) throws UserNotFoundException;
}
