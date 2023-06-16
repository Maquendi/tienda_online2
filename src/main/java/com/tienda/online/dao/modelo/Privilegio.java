package com.tienda.online.dao.modelo;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Privilegio implements Serializable{

	@Serial
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String nombrePrivilegio;
	
	
	public Privilegio() {}

	public Privilegio(String id, String nombrePrivilegio) {
		super();
		this.id = id;
		this.nombrePrivilegio = nombrePrivilegio;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombrePrivilegio() {
		return nombrePrivilegio;
	}

	public void setNombrePrivilegio(String nombrePrivilegio) {
		this.nombrePrivilegio = nombrePrivilegio;
	}

	@Override
	public String toString() {
		return "Privilegio [id=" + id + ", nombrePrivilegio=" + nombrePrivilegio + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombrePrivilegio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Privilegio other = (Privilegio) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombrePrivilegio, other.nombrePrivilegio);
	}
	
	
	
	
}
