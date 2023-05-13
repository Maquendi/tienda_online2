package modelo;

import java.io.Serializable;
import java.util.Objects;

public class CuentaBancaria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nombreBanco;
	
	private String tipoCuenta;
	
	private int clienteId;
	
	public CuentaBancaria() {}

	public CuentaBancaria(String nombreBanco, String tipoCuenta, int clienteId) {
		super();
		this.nombreBanco = nombreBanco;
		this.tipoCuenta = tipoCuenta;
		this.clienteId = clienteId;
	}

	public String getNombreBanco() {
		return nombreBanco;
	}

	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [nombreBanco=" + nombreBanco + ", tipoCuenta=" + tipoCuenta
				+ ", clienteId=" + clienteId +"]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(clienteId, nombreBanco, tipoCuenta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaBancaria other = (CuentaBancaria) obj;
		return clienteId == other.clienteId && Objects.equals(nombreBanco, other.nombreBanco)
				&& Objects.equals(tipoCuenta, other.tipoCuenta);
	}

	
}
