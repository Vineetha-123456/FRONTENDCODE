package com.placementmanagement.entity;
 
import jakarta.persistence.*;
@Entity
@Table(name="admin")
public class Admin {
	@Id
	private Integer Id;
	private String username;
	private String Email;
	private String Password;
	
	public Admin()
	{
		
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Admin(Integer id, String username, String email, String password) {
		super();
		Id = id;
		this.username = username;
		Email = email;
		Password = password;
	}

	@Override
	public String toString() {
		return "Admin [Id=" + Id + ", username=" + username + ", Email=" + Email + ", Password=" + Password + "]";
	}
	
}
