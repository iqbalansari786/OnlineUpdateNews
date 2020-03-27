package com.onlinenewsupdate.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="loginTable")
public class LoginModal {
	
	@Id
	private int id;
	 @NotBlank(message="plz enter email")
   
	private String email;
	 @NotBlank(message="plz enter password")
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginModal [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	

}
