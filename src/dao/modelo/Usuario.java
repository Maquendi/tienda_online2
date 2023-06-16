package dao.modelo;

import java.io.Serializable;
import java.util.Objects;


//pojo -->> plain old java object....
//Dto -- >>  data transfer object....
public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String id;
	private String password;
	
	public Usuario() {}
	
	public Usuario(String userName, String id, String password) {
		super();
		this.userName = userName;
		this.id = id;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Usuario [userName=" + userName + ", id=" + id + ", password=" + password + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, password, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id) && Objects.equals(password, other.password)
				&& Objects.equals(userName, other.userName);
	}
}
