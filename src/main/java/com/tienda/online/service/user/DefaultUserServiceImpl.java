package com.tienda.online.service.user;


import com.tienda.online.dao.modelo.Persona;
import com.tienda.online.dao.modelo.Rol;
import com.tienda.online.dao.modelo.UserRole;
import com.tienda.online.dao.modelo.Usuario;
import com.tienda.online.dao.user.UserServiceDao;
import com.tienda.online.exceptions.UserDataNotFoundException;
import com.tienda.online.exceptions.UserDataValidationException;
import com.tienda.online.exceptions.UserNotFoundException;
import com.tienda.online.service.dto.UserDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class DefaultUserServiceImpl implements UserService {

	private final UserServiceDao userServiceDao;

	public DefaultUserServiceImpl(UserServiceDao userServiceDao) {
		this.userServiceDao = userServiceDao;
	}

	@Override
	public UserSession doLogin(String nombreUsuario, String contrasena)
			throws UserNotFoundException, UserDataNotFoundException {

		if (nombreUsuario == null || nombreUsuario.isEmpty()) {
			throw new UserNotFoundException("nombreUsuario no debe estar vacio");
		}

		if (contrasena == null || contrasena.isEmpty()) {
			throw new UserNotFoundException("contrasena no debe estar vacio");
		}

		List<Usuario> usuarios = userServiceDao.usuarios();

		Usuario usuarioEncontrado = usuarios.stream()
				.filter(user -> user.getUserName().equals(nombreUsuario) && user.getPassword().equals(contrasena))
				.findFirst()
				.orElseThrow(() -> new UserNotFoundException("El nombre de usuario o contrasena incorrecto"));

		List<Persona> personas = userServiceDao.personas();

		Persona datosPersonales = personas.stream().filter(persona -> persona.getId().equals(usuarioEncontrado.getId()))
				.findFirst().orElseThrow(() -> new UserDataNotFoundException());

		var userSession = new UserSession();

		userSession.setId(usuarioEncontrado.getId());
		userSession.setUserName(usuarioEncontrado.getUserName());
		userSession.setPassword(usuarioEncontrado.getPassword());
		userSession.setPersonaInfo(datosPersonales);

		final List<Rol> roles = userServiceDao.roles();

		List<UserRole> rolesAsignados = userServiceDao.userRoles();

		List<Rol> rolesDelUsuario = rolesAsignados.stream().filter(elem -> elem.getUserId().equals(userSession.getId()))
				.map(elem -> new Rol(elem.getRoleId())).collect(Collectors.toList());

		for (Rol rol : rolesDelUsuario) {
			String roleName = getRoleName(rol.getId(), roles)
					.orElseThrow(() -> new UserDataNotFoundException("Error de configuracion de roles de usuario"));
			rol.setNombreRol(roleName);
		}

		userSession.setUserRoles(rolesDelUsuario);

		return userSession;
	}

	private Optional<String> getRoleName(String roleId, List<Rol> roles) throws UserDataNotFoundException {
		return roles.stream().filter(item -> item.getId().equals(roleId)).map(item -> item.getNombreRol()).findFirst();
	}

	@Override
	public void doRegistration(UserDto userDto) throws UserDataValidationException {

		var emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

		String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";

		if (!userDto.getEmailAdress().matches(emailRegex)) {
			throw new UserDataValidationException(String.format("%s is not a valid email", userDto.getEmailAdress()));
		}

		if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
			throw new UserDataValidationException("password and confirm password must be equal");
		}

		if (!userDto.getPassword().matches(passwordRegex)) {
			throw new UserDataValidationException("password is not valid [at least 1 letter, 1 number, 8 characters]");
		}

		if (userServiceDao.findByEmail(userDto.getEmailAdress()).isPresent()) {
			throw new UserDataValidationException(String.format("%s is duplicated", userDto.getEmailAdress()));
		}

		if (userServiceDao.findUserByUserName(userDto.getUserName()).isPresent()) {
			throw new UserDataValidationException(String.format("%s is duplicated", userDto.getUserName()));
		}

		createUser(userDto);
	}

	private boolean createUser(UserDto userData) {

		userData.setId(UUID.randomUUID().toString());

		Persona nuevaPersona = new Persona();

		nuevaPersona.setEmailAdress(userData.getEmailAdress());
		nuevaPersona.setId(userData.getId());
		nuevaPersona.setName(userData.getName());
		nuevaPersona.setMyFirstLastname(userData.getMyFirstLastname());
		nuevaPersona.setMySecondLastname(userData.getMySecondLastname());
		nuevaPersona.setMyDateOfBirth(userData.getMyDateOfBirth());
		nuevaPersona.setSex(userData.getSex());

		Usuario usuario = new Usuario();

		usuario.setId(userData.getId());
		usuario.setUserName(userData.getUserName());
		usuario.setPassword(userData.getPassword());

		userServiceDao.persist(nuevaPersona, usuario);

		return true;
	}

	@Override
	public void changePassword(String userId, String password, String confirmPassword)
			throws UserNotFoundException, UserDataValidationException {

		String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";

		if (!password.equals(confirmPassword)) {
			throw new UserDataValidationException("password and confirm password must be equal");
		}

		if (!password.matches(passwordRegex)) {
			throw new UserDataValidationException("password is not valid [at least 1 letter, 1 number, 8 characters]");
		}

		var usuario = userServiceDao.findUserById(userId).orElseThrow(() -> new UserNotFoundException(
				"El usuario con id " + userId + " no se encuentra en nuestros registros"));

		usuario.setPassword(password);

		userServiceDao.update(usuario);
	}

	@Override
	public Optional<Persona> getUserByEmail(String email) {
		return userServiceDao.findByEmail(email);
	}

}
