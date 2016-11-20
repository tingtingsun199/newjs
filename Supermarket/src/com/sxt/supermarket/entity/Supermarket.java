package com.sxt.supermarket.entity;
/**
 * ÉÌÆ·Àà
 * @author lenovo
 *
 */
public class Supermarket {
	private int id;
	
	private String name;
	
	private String number;
	
	private String rise;
	
	private String standard;
	
	private String entrepot;
	
	public Supermarket(){
		
		
	}
		public Supermarket( String name, String number, String rise,
				String standard,String entrepot) {
			this.name = name;
			this.number = number;
			this.rise = rise;
			this.standard = standard;
			this.entrepot =entrepot;
		
	
	}

	public Supermarket(int id, String name, String number, String rise,
			String standard, String entrepot) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.rise = rise;
		this.standard = standard;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getRise() {
		return rise;
	}

	public void setRise(String rise) {
		this.rise = rise;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getEntrepot() {
		return entrepot;
	}

	public void setEntrepot(String entrepot) {
		this.entrepot = entrepot;
	}

}