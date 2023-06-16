package com.tienda.online.dao.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Merchant implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String nombre;
	
	private String tipoNegocio;
	
	public Merchant() {}

	public Merchant(String id, String nombre, String tipoNegocio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipoNegocio = tipoNegocio;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoNegocio() {
		return tipoNegocio;
	}

	public void setTipoNegocio(String tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}

	@Override
	public String toString() {
		return "Merchant [id=" + id + ", nombre=" + nombre + ", tipoNegocio=" + tipoNegocio + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, tipoNegocio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Merchant other = (Merchant) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(tipoNegocio, other.tipoNegocio);
	}
	
	
}
