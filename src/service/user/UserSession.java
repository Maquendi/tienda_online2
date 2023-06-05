package service.user;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import modelo.Persona;
import modelo.Rol;

// pojo .... 

public class UserSession {

	private String id;
	
	private String userName;
	
	private String password;
		
	private Persona personaInfo;
	
	private List<Rol> userRoles; // rolesDelUsuario

	public UserSession(String id, String userName, String password, Persona personaInfo) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.personaInfo = personaInfo;
	}
	
	// default constructor
	public UserSession() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Persona getPersonaInfo() {
		return personaInfo;
	}

	public void setPersonaInfo(Persona personaInfo) {
		this.personaInfo = personaInfo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, password, personaInfo, userName);
	}
	
	public List<Rol> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<Rol> userRoles) {
		this.userRoles = userRoles;
	}
	
	public boolean isAdmin() {
	  return userRoles.stream().anyMatch(rol -> rol.getNombreRol().equals("Admin"));
	}
	
	public boolean isComerciante() {
		return userRoles.stream().anyMatch(rol -> rol.getNombreRol().equals("Comerciante"));
	}
	
	public boolean isClient() {
		return userRoles.stream().anyMatch(rol -> rol.getNombreRol().equals("Cliente"));
	}
	
	public boolean isMensajero() {
		return userRoles.stream().anyMatch(rol -> rol.getNombreRol().equals("Mensajero"));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserSession other = (UserSession) obj;
		return Objects.equals(id, other.id) && Objects.equals(password, other.password)
				&& Objects.equals(personaInfo, other.personaInfo) && Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "UserSession [id=" + id + ", userName=" + userName + ", password=" + password + ", personaInfo="
				+ personaInfo + ", userRoles=" + userRoles + "]";
	}
	
}
