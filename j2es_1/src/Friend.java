/**
 * ������
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
		//����
		this.name = name;
		//�칫�ҵ绰
		this.officephone = officephone;
		//��ͥ�绰
		this.homephone = homephone;
		//��ͥ��ַ
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
