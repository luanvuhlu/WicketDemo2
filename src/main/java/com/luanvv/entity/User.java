package com.luanvv.entity;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fullName;
	private String email;
	private String dateOfBirth;
	private String password;
	private boolean alive;
	public User() {
	}
	public String getFullName() {
		return fullName;
	}
	public String getEmail() {
		return email;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public String getPassword() {
		return password;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}
