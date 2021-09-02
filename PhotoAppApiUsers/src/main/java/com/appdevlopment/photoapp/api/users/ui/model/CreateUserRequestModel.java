package com.appdevlopment.photoapp.api.users.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {
	

	@NotNull(message="First Name cannot be NUll")
	@Size(min=2,message="Fist name should not be less than two characters.")
	private String firstName;
	
	@NotNull(message="last Name cannot be NUll")
	@Size(min=2,message="last name should not be less than two characters.")
	private String lastName;
	
	@NotNull(message="Password cannot be NUll")
	@Size(min=8,max=16,message="Password Should be equal or greater than 8 or equal or less than 16 characters.")
	private String password;
	
	@NotNull(message="Email cannot be NUll")
	@Email
	private String email;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
