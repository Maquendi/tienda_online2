package modelo;

import java.io.Serializable;
import java.util.Objects;

public class CuentaBancaria implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private double saldo;
	
	private String nombreBanco;
	
	private String tipoCuenta;
	
	private int clienteId;
	
	Cliente cliente;
	
	public CuentaBancaria() {}

	public CuentaBancaria(double saldo, String nombreBanco, String tipoCuenta, int clienteId, Cliente cliente) {
		super();
		this.saldo = saldo;
		this.nombreBanco = nombreBanco;
		this.tipoCuenta = tipoCuenta;
		this.clienteId = clienteId;
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
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
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [saldo=" + saldo + ", nombreBanco=" + nombreBanco + ", tipoCuenta=" + tipoCuenta
				+ ", clienteId=" + clienteId + ", cliente=" + cliente + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, clienteId, nombreBanco, saldo, tipoCuenta);
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
		return Objects.equals(cliente, other.cliente) && clienteId == other.clienteId
				&& Objects.equals(nombreBanco, other.nombreBanco)
				&& Double.doubleToLongBits(saldo) == Double.doubleToLongBits(other.saldo)
				&& Objects.equals(tipoCuenta, other.tipoCuenta);
	}
	
}
