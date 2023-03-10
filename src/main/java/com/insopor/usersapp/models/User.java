package com.insopor.usersapp.models;

public class User {

	private String nickname;
	private String password;
	private String username;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public User(String nickname, String password, String username) {
		super();
		this.nickname = nickname;
		this.password = password;
		this.username = username;
	}
	
	public User() {
		
	}
	
}
