package service.user;

import java.util.ArrayList;
import java.util.List;

import dao.compartido.LectorDeArchivo;
import dao.persona.PersonDeserializer;
import dao.rol.RolDeserializer;
import dao.rol.UserRoleDeserializer;
import dao.usuario.UsuarioDeserializer;
import modelo.Persona;
import modelo.Rol;
import modelo.UserRole;
import modelo.Usuario;

public class DefaultUserServiceImpl implements UserService {
	// campo,
	// field
	private LectorDeArchivo fileReader;

	private final String ARCHIVO_USUARIO = "archivo_usuarios";

	private final String ARCHIVO_PERSONA = "archivo_personas";

	private final String ARCHIVO_ROLES = "archivo_rol";

	private final String ARCHIVO_ROLES_ASIGNADO = "archivo_usuario_rol";

	public DefaultUserServiceImpl(LectorDeArchivo fileReader) {
		this.fileReader = fileReader;
	}

	@Override
	public UserSession doLogin(String nombreUsuario, String contrasena)
			throws UserNotFoundException, UserDataNotFoundException {

		// validar que los datos no esten nulos o vacios
		// leer el archivo_usuarios,
		// tratar encontrar usuario y contrasena
		// leer el archivo_persona,
		// leer el archivo_role,
		// leer el archivo_privilegio,

		// si se valida los datos, crear un objeto tipo UserSession y devolverlo
		// si no se validan los datos, lanzar una exception de tipo
		// UserNotFoundException

		if (nombreUsuario == null || nombreUsuario.isEmpty()) {
			throw new UserNotFoundException("nombreUsuario no debe estar vacio");
		}

		if (contrasena == null || contrasena.isEmpty()) {
			throw new UserNotFoundException("contrasena no debe estar vacio");
		}

		Object[] usuarios = fileReader.leer(ARCHIVO_USUARIO, new UsuarioDeserializer());

		Usuario usuarioEncontrado = null;

		for (int i = 0; i < usuarios.length; i++) {
			var usuario = (Usuario) usuarios[i];
			if (usuario.getUserName().equals(nombreUsuario) && usuario.getPassword().equals(contrasena)) {
				usuarioEncontrado = usuario;
				break; // parar de iterar
			}
		}

		if (usuarioEncontrado == null) {
			// el usuario no fue encontrado.
			throw new UserNotFoundException("El nombre de usuario o contrasena incorrecto");
		}

		Object[] personas = fileReader.leer(ARCHIVO_PERSONA, new PersonDeserializer());

		int index = 0;

		Persona datosPersonales = null;

		while (index < personas.length) {
			var persona = (Persona) personas[index];
			if (persona.getId().equals(usuarioEncontrado.getId())) {
				datosPersonales = persona;
				break;
			}
			index++;
		}

		if (datosPersonales == null) {
			throw new UserDataNotFoundException();
		}

		var userSession = new UserSession();

		userSession.setId(usuarioEncontrado.getId());
		userSession.setUserName(usuarioEncontrado.getUserName());
		userSession.setPassword(usuarioEncontrado.getPassword());
		userSession.setPersonaInfo(datosPersonales);

		// leer los roles, archivo_rol,
		// leer la asociacion de roles con usuario,

		Object[] roles = fileReader.leer(ARCHIVO_ROLES, new RolDeserializer());

		Object[] rolesAsignados = fileReader.leer(ARCHIVO_ROLES_ASIGNADO, new UserRoleDeserializer());

		List<Rol> rolesDelUsuario = new ArrayList<>();

		for (int i = 0; i < rolesAsignados.length; i++) {

			var rolAsignado = (UserRole) rolesAsignados[i];

			if (rolAsignado.getUserId().equals(userSession.getId())) {

				var nuevoRole = new Rol();

				nuevoRole.setId(rolAsignado.getRoleId());

				for (int j = 0; j < roles.length; j++) {

					var r = (Rol) roles[j];

					if (r.getId().equals(rolAsignado.getRoleId())) {
						nuevoRole.setNombreRol(r.getNombreRol());
						break;
					}
				}

				if (nuevoRole.getNombreRol() == null) {

					throw new UserDataNotFoundException("Error de configuracion de roles de usuario");
				}

				rolesDelUsuario.add(nuevoRole);
			}
		}

		if (rolesDelUsuario.isEmpty()) {

			throw new UserDataNotFoundException("Error de configuracion de roles de usuario");
		}
		
		
		userSession.setUserRoles(rolesDelUsuario);

		return userSession;
	}

	@Override
	public void doRegistration() {
		System.out.println("You selected Register");
	}

}
