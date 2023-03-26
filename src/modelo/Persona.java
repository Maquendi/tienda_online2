package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
    private String id; // gererar automatico
	private String nombre;
	private String apellidoMaterno;
	private String apellidoPaterno;
	private LocalDate fechaDeNacimiento;
	private String sexo;
	
	public Persona() {}
	
	
	public Persona(String email, String id, String nombre, String apellidoMaterno, String apellidoPaterno,
			LocalDate fechaDeNacimiento, String sexo) {
		super();
		this.email = email;
		this.id = id;
		this.nombre = nombre;
		this.apellidoMaterno = apellidoMaterno;
		this.apellidoPaterno = apellidoPaterno;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	@Override
	public String toString() {
		return "Persona [email=" + email + ", id=" + id + ", nombre=" + nombre + ", apellidoMaterno=" + apellidoMaterno
				+ ", apellidoPaterno=" + apellidoPaterno + ", fechaDeNacimiento=" + fechaDeNacimiento + ", sexo=" + sexo
				+ "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(apellidoMaterno, apellidoPaterno, email, fechaDeNacimiento, id, nombre, sexo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellidoMaterno, other.apellidoMaterno)
				&& Objects.equals(apellidoPaterno, other.apellidoPaterno) && Objects.equals(email, other.email)
				&& Objects.equals(fechaDeNacimiento, other.fechaDeNacimiento) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(sexo, other.sexo);
	}

	
	
	
	
	
	
	
	
}
