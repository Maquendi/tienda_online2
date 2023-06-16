package service.user;

import java.util.Optional;

import dao.modelo.Persona;
import service.dto.UserDto;

public interface UserService {
	
	UserSession doLogin(String nombreUsuario, String contrasena) throws UserNotFoundException, UserDataNotFoundException;
	
	void doRegistration(UserDto userDto) throws UserDataValidationException;
	
	Optional<Persona> getUserByEmail(String email);
	
	void changePassword(String userId, String password, String confirmPassword) throws UserNotFoundException, UserDataValidationException;	
}
