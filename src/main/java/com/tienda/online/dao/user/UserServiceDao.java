package com.tienda.online.dao.user;

import java.util.List;
import java.util.Optional;

import com.tienda.online.dao.modelo.Persona;
import com.tienda.online.dao.modelo.Privilegio;
import com.tienda.online.dao.modelo.Rol;
import com.tienda.online.dao.modelo.UserRole;
import com.tienda.online.dao.modelo.Usuario;
import com.tienda.online.exceptions.UserNotFoundException;

public interface UserServiceDao {

	void persist(Persona personalInfo, Usuario user);
	
	Optional<Persona> findByEmail(String email);
	
	Optional<Persona> findById(String id);
	
	Optional<Usuario> findUserByEmail(String email);
	
	Optional<Usuario> findUserById(String id);
	
	Optional<Usuario> findUserByUserName(String userName);
	
	void update(Persona personalInfo) throws UserNotFoundException;
	
	void update( Usuario user) throws UserNotFoundException ;
	
	List<Persona> personas();
	
	List<Usuario> usuarios();
	
	List<Rol> roles();
	
	List<Privilegio> privilegios();
	
	List<UserRole> userRoles();
}
