package modelo;

import java.io.Serializable;
import java.util.Objects;

public class CategoriaProducto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String nombreDeCategoria;
	
	
	public CategoriaProducto() {}
	
	
	public CategoriaProducto(String id, String nombreDeCategoria) {
		super();
		this.id = id;
		this.nombreDeCategoria = nombreDeCategoria;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNombreDeCategoria() {
		return nombreDeCategoria;
	}
	
	public void setNombreDeCategoria(String nombreDeCategoria) {
		this.nombreDeCategoria = nombreDeCategoria;
	}
	
	@Override
	public String toString() {
		return "CategoriaProducto [id=" + id + ", nombreDeCategoria=" + nombreDeCategoria + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, nombreDeCategoria);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaProducto other = (CategoriaProducto) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombreDeCategoria, other.nombreDeCategoria);
	}
	
	

}
