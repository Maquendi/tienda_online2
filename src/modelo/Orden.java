package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Orden implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private LocalDate fechaOrden;
	
	private Producto[] productos;
	
	public Orden() {}
	


	public Orden(String id, LocalDate fechaOrden, Producto[] productos) {
		super();
		this.id = id;
		this.fechaOrden = fechaOrden;
		this.productos = productos;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getFechaOrden() {
		return fechaOrden;
	}

	public void setFechaOrden(LocalDate fechaOrden) {
		this.fechaOrden = fechaOrden;
	}

	public Producto[] getProductos() {
		return productos;
	}

	public void setProductos(Producto[] productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Orden [id=" + id + ", fechaOrden=" + fechaOrden + ", productos=" + Arrays.toString(productos) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(productos);
		result = prime * result + Objects.hash(fechaOrden, id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orden other = (Orden) obj;
		return Objects.equals(fechaOrden, other.fechaOrden) && Objects.equals(id, other.id)
				&& Arrays.equals(productos, other.productos);
	}
	
	
}
