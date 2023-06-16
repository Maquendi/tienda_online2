package com.tienda.online.service.dto;

import java.time.LocalDate;
import java.util.Objects;

public class UserDto {
	private String emailAdress;
    private String id; // generar automatico
	private String name;
	private String myFirstLastname;
	private String mySecondLastname;
	private LocalDate myDateOfBirth;
	private String sex;
	private String userName;
	private String password;
	private String confirmPassword;
	
	public UserDto() {}
	
	public UserDto(String emailAdress, String id, String name, String myFirstLastname, String mySecondLastname,
			LocalDate myDateOfBirth, String sex, String userName, String password) {
		super();
		this.emailAdress = emailAdress;
		this.id = id;
		this.name = name;
		this.myFirstLastname = myFirstLastname;
		this.mySecondLastname = mySecondLastname;
		this.myDateOfBirth = myDateOfBirth;
		this.sex = sex;
		this.userName = userName;
		this.password = password;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserDto [emailAdress=" + emailAdress + ", id=" + id + ", name=" + name + ", myFirstLastname="
				+ myFirstLastname + ", mySecondLastname=" + mySecondLastname + ", myDateOfBirth=" + myDateOfBirth
				+ ", sex=" + sex + ", userName=" + userName + ", password=" + password + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(emailAdress, id, myDateOfBirth, myFirstLastname, mySecondLastname, name, password, sex,
				userName);
	}
	
	
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		return Objects.equals(emailAdress, other.emailAdress) && Objects.equals(id, other.id)
				&& Objects.equals(myDateOfBirth, other.myDateOfBirth)
				&& Objects.equals(myFirstLastname, other.myFirstLastname)
				&& Objects.equals(mySecondLastname, other.mySecondLastname) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(sex, other.sex)
				&& Objects.equals(userName, other.userName);
	}
}
