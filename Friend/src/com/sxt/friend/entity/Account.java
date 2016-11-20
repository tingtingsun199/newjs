package com.sxt.friend.entity;
/**
 * ’À∫≈¿‡
 * @author lenovo
 *
 */
public class Account {
	
	private int id;
	
	private String username;
	
	private String pwd;
	
	private int stat;
	public Account(){
		
	}
	public Account(int id, String username, String pwd, int stat) {
		super();
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.stat = stat;
	}
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	
}