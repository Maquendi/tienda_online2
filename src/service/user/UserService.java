package service.user;

import java.util.Optional;

import dao.modelo.Usuario;
import service.dto.UserDto;
import dao.modelo.Persona;

public interface UserService {
	
	UserSession doLogin(String nombreUsuario, String contrasena) throws UserNotFoundException, UserDataNotFoundException;
	
	void doRegistration(UserDto userDto);
	
	Optional<Persona> getUserByEmail(String email);

	void changePassword(String userId, String password) throws UserNotFoundException;
	
	
}
