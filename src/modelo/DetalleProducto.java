package modelo;

import java.io.Serializable;
import java.util.Objects;

public class DetalleProducto implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String color; 
    
    private String textura;
    
    private double ancho;
    
    private double largo;
    
    private boolean tieneDescuento;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTextura() {
		return textura;
	}

	public void setTextura(String textura) {
		this.textura = textura;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}

	public boolean isTieneDescuento() {
		return tieneDescuento;
	}

	public void setTieneDescuento(boolean tieneDescuento) {
		this.tieneDescuento = tieneDescuento;
	}

	@Override
	public String toString() {
		return "DetalleProducto [color=" + color + ", textura=" + textura + ", ancho=" + ancho + ", largo=" + largo
				+ ", tieneDescuento=" + tieneDescuento + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ancho, color, largo, textura, tieneDescuento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleProducto other = (DetalleProducto) obj;
		return Double.doubleToLongBits(ancho) == Double.doubleToLongBits(other.ancho)
				&& Objects.equals(color, other.color)
				&& Double.doubleToLongBits(largo) == Double.doubleToLongBits(other.largo)
				&& Objects.equals(textura, other.textura) && tieneDescuento == other.tieneDescuento;
	}
    
    
}
