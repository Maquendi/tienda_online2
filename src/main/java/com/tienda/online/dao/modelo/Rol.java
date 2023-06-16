package com.tienda.online.dao.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Rol implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String nombreRol;
	
	public Rol() {}
	
	public Rol(String id) {
		this.id = id;
	}
	
	public Rol(String id, String nombreRol) {
		super();
		this.id = id;
		this.nombreRol = nombreRol;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombreRol=" + nombreRol + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombreRol);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol other = (Rol) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombreRol, other.nombreRol);
	}
	
	
	
	
}
