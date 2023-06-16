package com.tienda.online.service.user;

import com.tienda.online.dao.modelo.Persona;
import com.tienda.online.exceptions.UserDataNotFoundException;
import com.tienda.online.exceptions.UserDataValidationException;
import com.tienda.online.exceptions.UserNotFoundException;
import com.tienda.online.service.dto.UserDto;

import java.util.Optional;

public interface UserService {
	
	UserSession doLogin(String nombreUsuario, String contrasena) throws UserNotFoundException, UserDataNotFoundException;
	
	void doRegistration(UserDto userDto) throws UserDataValidationException;
	
	Optional<Persona> getUserByEmail(String email);
	
	void changePassword(String userId, String password, String confirmPassword) throws UserNotFoundException, UserDataValidationException;	
}
