/**
 * 朋友类
 * @author lenovo
 *
 */
public class Friend {

	private String name;
	private String officephone;
	private String homephone;
	private String address;
	
	public Friend(){
		
	}

	public Friend(String name, String officephone, String homephone,
			String address) {
		super();
		//姓名
		this.name = name;
		//办公室电话
		this.officephone = officephone;
		//家庭电话
		this.homephone = homephone;
		//家庭地址
		this.address = address;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOfficephone() {
		return officephone;
	}

	public void setOfficephone(String officephone) {
		this.officephone = officephone;
	}

	public String getHomephone() {
		return homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
