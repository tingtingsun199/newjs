package com.sxt.supermarket.entity;

public class Date {
private int id;
	
	private String name;
	
	private String date;
	
	private String entrepot;
	
	public Date(){
		
	}

	public Date(String name, String date, String entrepot) {
		super();
		this.name = name;
		this.date = date;
		this.entrepot = entrepot;
	}

	public Date(int id, String name, String date, String entrepot) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.entrepot = entrepot;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEntrepot() {
		return entrepot;
	}

	public void setEntrepot(String entrepot) {
		this.entrepot = entrepot;
	}
	
}