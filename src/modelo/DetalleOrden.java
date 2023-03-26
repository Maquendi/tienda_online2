package modelo;
import java.io.Serializable;
import java.util.Objects;

public class DetalleOrden implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean estaDisponible;
	
	public DetalleOrden() {}
	

	public DetalleOrden(boolean estaDisponible) {
		super();
		this.estaDisponible = estaDisponible;
	}



	public boolean isEstaDisponible() {
		return estaDisponible;
	}

	public void setEstaDisponible(boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
	}

	@Override
	public String toString() {
		return "DetalleOrden [estaDisponible=" + estaDisponible + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(estaDisponible);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleOrden other = (DetalleOrden) obj;
		return estaDisponible == other.estaDisponible;
	}
	
	
	
}
