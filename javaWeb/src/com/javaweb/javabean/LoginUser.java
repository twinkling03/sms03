package com.javaweb.javabean;

/**
 * 
 * @author Administrator
 *
 */
public class LoginUser {
	
	private int id; //对应数据库login 表的ID列
	private String username; 
	private String password;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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


}
