package com.bridgelabz.login.model;

public class Users {
	private int user_id;
	private String username;
	private String gmail;
	private String password;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", username=" + username + ", gmail=" + gmail + ", password=" + password
				+ "]";
	}

}
