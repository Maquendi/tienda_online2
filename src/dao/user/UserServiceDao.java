package dao.user;

import java.util.List;
import java.util.Optional;

import dao.modelo.Persona;
import dao.modelo.Privilegio;
import dao.modelo.Rol;
import dao.modelo.UserRole;
import dao.modelo.Usuario;
import service.user.UserNotFoundException;

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
