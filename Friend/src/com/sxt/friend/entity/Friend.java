package com.sxt.friend.entity;
/**
 * ≈Û”—¿‡
 * @author lenovo
 *
 */
public class Friend {
	
	private int id;
	
	private String name;
	
	private String officePhone;
	
	private String homePhone;
	
	private String address;
	
	public Friend(){
		
	}

	public Friend( String name, String officePhone, String homePhone,
			String address) {
		this.name = name;
		this.officePhone = officePhone;
		this.homePhone = homePhone;
		this.address = address;
	}
	
	
	
	public Friend(int id, String name, String officePhone, String homePhone,
			String address) {
		super();
		this.id = id;
		this.name = name;
		this.officePhone = officePhone;
		this.homePhone = homePhone;
		this.address = address;
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

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
