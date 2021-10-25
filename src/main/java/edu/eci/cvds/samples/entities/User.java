package edu.eci.cvds.samples.entities;

import java.io.Serializable;

public class User implements Serializable{

	private String userName;
	private String name;
	private String mail;
	private String passwd;
	private String rol;
	
	public User() {
		
	}
	
	public User(String userName, String name, String mail, String passwd, String rol) {
		this.userName = userName;
		this.name = name;
		this.mail = mail;
		this.passwd = passwd;
		this.rol = rol;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getRol() {
		return rol;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", name=" + name + ", mail=" + mail + ", passwd=" + passwd + ", rol="
				+ rol + "]" + "\n\t";
	}
}
