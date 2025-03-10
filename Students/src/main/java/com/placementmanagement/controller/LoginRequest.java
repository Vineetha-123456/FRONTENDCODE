package com.placementmanagement.controller;

public class LoginRequest {
    private String username;
    private String password;

    // Getters and Setters
    

    public String getPassword() {
        return password;
    }

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
        this.password = password;
    }

	public LoginRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public LoginRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "LoginRequest [username=" + username + ", password=" + password + "]";
	}
	
	
}

