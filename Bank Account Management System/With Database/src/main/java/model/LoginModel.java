package model;

public class LoginModel {
	private String username;
	private String password;
	
	//First Constructor
	public LoginModel(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	//Second Constructor
	public LoginModel(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
