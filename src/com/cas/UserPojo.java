package com.cas;

public class UserPojo {
	private String email;
	private String username;
	private String password;
	//private String role;
	
	public UserPojo(String email, String username, String password) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		//this.role = role;
	}
	
	public UserPojo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		//this.role = role;
	}
	
	public UserPojo() {
		super();
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public String getRole() {
//		return role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}
	
}
