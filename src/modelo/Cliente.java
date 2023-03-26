package modelo;

import java.io.Serializable;
import java.util.Objects;

public class Cliente extends Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cuentaBancaria;
	
	public Cliente() {}

	public Cliente(String cuentaBancaria) {
		super();
		this.cuentaBancaria = cuentaBancaria;
	}

	public String getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	@Override
	public String toString() {
		return "Cliente [cuentaBancaria=" + cuentaBancaria + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cuentaBancaria);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cuentaBancaria, other.cuentaBancaria);
	}
	
	
	
}
