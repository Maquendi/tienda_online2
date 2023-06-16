package dao.modelo;

import java.io.Serializable;
import java.util.Objects;

public class CuentaBancaria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nombreBanco;
	
	private String tipoCuenta;
	
	private int clienteId;
	
	private String numDeCuenta;
	
	public CuentaBancaria() {}

	public CuentaBancaria(String nombreBanco, String tipoCuenta, int clienteId, String numDeCuenta) {
		super();
		this.nombreBanco = nombreBanco;
		this.tipoCuenta = tipoCuenta;
		this.clienteId = clienteId;
		this.numDeCuenta = numDeCuenta;
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
	
	public String getNumDeCuenta() {
		return numDeCuenta;
	}
	
	public void setNumDeCuenta(String numDeCuenta) {
		this.numDeCuenta = numDeCuenta;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [nombreBanco=" + nombreBanco + ", tipoCuenta=" + tipoCuenta
				+ ", clienteId=" + clienteId + ", numero de cuenta=" + numDeCuenta + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(clienteId, nombreBanco, numDeCuenta, tipoCuenta);
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
				&& numDeCuenta == other.numDeCuenta && Objects.equals(tipoCuenta, other.tipoCuenta);
	}

	
}
