package com.lmf.po;

import com.jfinal.plugin.activerecord.Model;

public class User extends Model<User>{
	
	public static final User user = new User();
	private String username;
	private String password;
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
	

}
