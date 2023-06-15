package dao.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import dao.compartido.EscritorDeArchivo;
import dao.compartido.EscritorDeArchivoDeTexto;
import dao.compartido.LectorDeArchivo;
import dao.compartido.LectorDeArchivoDeTexto;
import dao.compartido.Linea;
import dao.modelo.Persona;
import dao.modelo.Privilegio;
import dao.modelo.Rol;
import dao.modelo.UserRole;
import dao.modelo.Usuario;
import dao.persona.PersonDeserializer;
import dao.persona.PersonSerializer;
import dao.privilegio.PrivilegioDeSerializer;
import dao.rol.RolDeserializer;
import dao.rol.UserRoleDeserializer;
import dao.usuario.UsuarioDeserializer;
import dao.usuario.UsuarioSerializer;
import service.user.UserNotFoundException;

public class TextFileUserServiceDao implements UserServiceDao {

	private LectorDeArchivo fileReader;

	private EscritorDeArchivo fileWriter;

	private final String ARCHIVO_ROLES = "archivo_rol";

	private final String ARCHIVO_ROLES_ASIGNADO = "archivo_usuario_rol";

	private static final String ARCHIVO_PERSONAS = "archivo_personas";

	private static final String ARCHIVO_USUARIOS = "archivo_usuarios";

	private final String ARCHIVO_PRIVILEGIOS = "archivo_privilegio";

	public TextFileUserServiceDao() {

		fileReader = new LectorDeArchivoDeTexto();
		fileWriter = new EscritorDeArchivoDeTexto();

	}

	@Override
	public void persist(Persona personalInfo, Usuario user) {

		Linea archivoTexto = new Linea();

		PersonSerializer serializer = new PersonSerializer(personalInfo);

		String personaValor = serializer.serializar();

		archivoTexto.setContenido(personaValor);

		fileWriter.escribir(ARCHIVO_PERSONAS, archivoTexto);

		crearUsuario(user);
	}

	@Override
	public Optional<Persona> findByEmail(String email) {
		// TODO Auto-generated method stub
		return personas().stream().filter(elem -> elem.getEmailAdress().equals(email)).findFirst();
	}

	@Override
	public Optional<Persona> findById(String id) {

		return personas().stream().filter(elem -> elem.getId().equals(id)).findFirst();
	}

	@Override
	public Optional<Usuario> findUserByEmail(String email) {

		// Java Stream api

		// TODO Auto-generated method stub
		return personas().stream().filter(p -> p.getEmailAdress().equals(email))
				.map(elem -> findUserById(elem.getId()).orElse(null)).filter(Objects::nonNull).findFirst();
	}

	@Override
	public Optional<Usuario> findUserById(String id) {

		return usuarios().stream().filter(user -> user.getId().equals(id)).findFirst();
	}

	@Override
	public Optional<Usuario> findUserByUserName(String userName) {
		return usuarios().stream().filter(user -> user.getUserName().equals(userName)).findFirst();
	}

	@Override
	public void update(Persona persona) throws UserNotFoundException {
		var personas = personas();

		var foundPersona = personas.stream().filter(elem -> elem.getId().equals(persona.getId())).findFirst()
				.orElseThrow(() -> new UserNotFoundException());

		foundPersona.setEmailAdress(persona.getEmailAdress());
		foundPersona.setSex(persona.getSex());
		foundPersona.setMyDateOfBirth(persona.getMyDateOfBirth());
		foundPersona.setMyFirstLastname(persona.getMyFirstLastname());
		foundPersona.setMySecondLastname(persona.getMySecondLastname());
		foundPersona.setName(persona.getName());

		var personaRows = personas.stream().map(elem -> this.convertir(elem)).collect(Collectors.toList());

		fileWriter.escribir(ARCHIVO_PERSONAS, personaRows);
	}

	@Override
	public void update(Usuario user) throws UserNotFoundException {
		var users = usuarios();

		var foundUser = users.stream().filter(elem -> elem.getId().equals(user.getId())).findFirst()
				.orElseThrow(() -> new UserNotFoundException());

		foundUser.setUserName(user.getUserName());
		foundUser.setPassword(user.getPassword());

		var userRows = users.stream().map(elem -> this.convertir(elem)).collect(Collectors.toList());

		fileWriter.escribir(ARCHIVO_USUARIOS, userRows);
	}

	private boolean crearUsuario(Usuario usuario) {
		var linea = convertir(usuario);
		fileWriter.escribir(ARCHIVO_USUARIOS, linea);
		return true;
	}

	public Linea convertir(Usuario usuario) {

		Linea userRow = new Linea();
		UsuarioSerializer serializer = new UsuarioSerializer(usuario);
		String UsuarioValor = serializer.serializar();
		userRow.setContenido(UsuarioValor);

		return userRow;
	}

	public Linea convertir(Persona persona) {

		Linea personaRow = new Linea();
		var serializer = new PersonSerializer(persona);
		String UsuarioValor = serializer.serializar();
		personaRow.setContenido(UsuarioValor);

		return personaRow;
	}

	@Override
	public List<Persona> personas() {
		var personaObjetos = fileReader.leer(ARCHIVO_PERSONAS, new PersonDeserializer());

		return convertArrayToListOfType(personaObjetos, Persona.class);
	}

	@Override
	public List<Usuario> usuarios() {

		var usuariosObjectos = fileReader.leer(ARCHIVO_USUARIOS, new UsuarioDeserializer());

		return convertArrayToListOfType(usuariosObjectos, Usuario.class);
	}

	public static <T> List<T> convertArrayToListOfType(Object[] array, Class<T> type) {
		List<T> list = new ArrayList<>();

		for (Object obj : array) {
			if (type.isInstance(obj)) {
				T element = type.cast(obj);
				list.add(element);
			}
		}

		return list;
	}

	@Override
	public List<Rol> roles() {

		var objetos = fileReader.leer(ARCHIVO_ROLES, new RolDeserializer());

		return convertArrayToListOfType(objetos, Rol.class);
	}

	@Override
	public List<Privilegio> privilegios() {
		var objetos = fileReader.leer(ARCHIVO_PRIVILEGIOS, new PrivilegioDeSerializer());

		return convertArrayToListOfType(objetos, Privilegio.class);
	}

	@Override
	public List<UserRole> userRoles() {
		var objetos = fileReader.leer(ARCHIVO_ROLES_ASIGNADO, new UserRoleDeserializer());

		return convertArrayToListOfType(objetos, UserRole.class);
	}

}
