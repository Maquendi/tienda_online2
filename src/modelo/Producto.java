package modelo;

import java.io.Serializable;
import java.util.Objects;

public class Producto implements Serializable{
	
	
	// Laptop dell inspiron, pantalla 15 pulg.
	// Computadoras,
	// id=sdfsdf5sdf1sfd44sdfsdfssds
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String descripcion;
	private String id;
	private CategoriaProducto categoria;
	
	public Producto() {}
	
	public Producto(String descripcion, String id, CategoriaProducto categoria) {
		super();
		this.descripcion = descripcion;
		this.id = id;
		this.categoria = categoria;
	}



	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public CategoriaProducto getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaProducto categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "Producto [descripcion=" + descripcion + ", id=" + id + ", categoria=" + categoria + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(categoria, descripcion, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(id, other.id);
	}
}
