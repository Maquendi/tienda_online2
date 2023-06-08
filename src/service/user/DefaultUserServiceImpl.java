package service.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import dao.compartido.EscritorDeArchivo;
import dao.compartido.LectorDeArchivo;
import dao.modelo.Rol;
import dao.modelo.UserRole;
import dao.modelo.Usuario;
import dao.persona.PersonDeserializer;
import dao.rol.RolDeserializer;
import dao.rol.UserRoleDeserializer;
import dao.usuario.UsuarioDeserializer;
import dao.modelo.Persona;
import service.UserRegistrationService;
import service.dto.UserDto;

public class DefaultUserServiceImpl implements UserService {
	// campo,
	// field
	private LectorDeArchivo fileReader;
	
	private EscritorDeArchivo fileWriter;
	
	private UserRegistrationService registrationService;

	private final String ARCHIVO_USUARIO = "archivo_usuarios";

	private final String ARCHIVO_PERSONA = "archivo_personas";

	private final String ARCHIVO_ROLES = "archivo_rol";

	private final String ARCHIVO_ROLES_ASIGNADO = "archivo_usuario_rol";

	public DefaultUserServiceImpl(LectorDeArchivo fileReader, EscritorDeArchivo fileWriter, UserRegistrationService registrationService) {
		this.fileReader = fileReader;
		this.fileWriter = fileWriter;
		this.registrationService = registrationService;
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
	public void doRegistration(UserDto userDto) {
		
		// validacion de datos.
		
		UserRegistrationService registrationService = new UserRegistrationService();
		registrationService.createUser(userDto);
		System.out.println("Ya se ha creado una nueva persona.");
	}

	@Override
	public Optional<Persona> getUserByEmail(String email) {
		
		Object[] personas = fileReader.leer(ARCHIVO_PERSONA, new PersonDeserializer());
		
		List<Object> personaList = Arrays.asList(personas);
		
		return personaList.stream()
		.map(elemAsObject -> (Persona)elemAsObject)
		.filter(persona -> persona.getEmailAdress().equals(email))
		.findFirst();
	}

	@Override
	public void changePassword(String userId, String password) throws UserNotFoundException {
		
		var usuarios = Arrays.asList(fileReader.leer(ARCHIVO_USUARIO, new UsuarioDeserializer()));
		
		var optionalUser = usuarios.stream().map(user -> (Usuario)user)
		        .filter(user -> user.getId().equals(userId))
		        .findFirst();
		
		var theUser = optionalUser.orElseThrow(() -> 
				new UserNotFoundException("El usuario con id " + userId + " no se encuentra en nuestros registros"));
		
		theUser.setPassword(password);
		
		
		var listaLinea = usuarios.stream().map(user -> registrationService.convertir((Usuario)user))
		       .collect(Collectors.toList());
		
		
		fileWriter.escribir(ARCHIVO_USUARIO, listaLinea);
	}
}
