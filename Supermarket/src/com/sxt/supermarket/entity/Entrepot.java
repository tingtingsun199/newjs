package com.sxt.supermarket.entity;
/**
 * ≤÷ø‚–≈œ¢
 * @author lenovo
 *
 */
public class Entrepot {
	private int id;
	
	private String name;
	
	private String nature;
	
	public Entrepot(){
		
	}
	public Entrepot( String name, String entrepot) {
		this.name = name;
		this.nature =entrepot;
	}
	public Entrepot(int id, String name, String nature) {
		super();
		this.id = id;
		this.name = name;
		this.nature = nature;
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
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	
}