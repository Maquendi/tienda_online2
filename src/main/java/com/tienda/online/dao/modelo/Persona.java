package com.tienda.online.dao.modelo;


import java.time.LocalDate;
import java.util.Objects;

public class Persona {

	private static final long serialVersionUID = 1L;
	private String emailAdress;
    private String id; // generar automatico
	private String name;
	private String myFirstLastname;
	private String mySecondLastname;
	private LocalDate myDateOfBirth;
	private String sex;
	
	public Persona() {}
	
	public Persona(String emailAdress, String id, String name, String myFirstLastname, String mySecondLastname,
			LocalDate miDateOfBirth, String sex) {
		super();
		this.emailAdress = emailAdress;
		this.id = id;
		this.name = name;
		this.myFirstLastname = myFirstLastname;
		this.mySecondLastname = mySecondLastname;
		this.myDateOfBirth = myDateOfBirth;
		this.sex = sex;
	}
	public String getEmailAdress() {
		return emailAdress;
	}
	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMyFirstLastname() {
		return myFirstLastname;
	}
	public void setMyFirstLastname(String myFirstLastname) {
		this.myFirstLastname = myFirstLastname;
	}
	public String getMySecondLastname() {
		return mySecondLastname;
	}
	public void setMySecondLastname(String mySecondLastname) {
		this.mySecondLastname = mySecondLastname;
	}
	public LocalDate getMyDateOfBirth() {
		return myDateOfBirth;
	}
	public void setMyDateOfBirth(LocalDate myDateOfBirth) {
		this.myDateOfBirth = myDateOfBirth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Persona [email=" + emailAdress + ", id=" + id + ", nombre=" + name + ", apellidoPaterno=" + myFirstLastname
				+ ", apellidoMaterno=" + mySecondLastname + ", fechaDeNacimiento=" + myDateOfBirth + ", sexo=" + sex
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(emailAdress, id, myDateOfBirth, myFirstLastname, mySecondLastname, name, sex);
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
		return Objects.equals(emailAdress, other.emailAdress) && Objects.equals(id, other.id)
				&& Objects.equals(myDateOfBirth, other.myDateOfBirth)
				&& Objects.equals(myFirstLastname, other.myFirstLastname)
				&& Objects.equals(mySecondLastname, other.mySecondLastname) && Objects.equals(name, other.name)
				&& sex == other.sex;
	}
	
}
