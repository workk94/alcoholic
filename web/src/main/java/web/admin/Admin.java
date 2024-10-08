package web.admin;

public class Admin {
	String id;
	String pw;
	String name;
	String ssn;
	String phone;
	String address;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	public Admin(String id, String pw, String name, String ssn, String phone, String address) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.address = address;
	}
	public Admin(String id, String pw, String name, String phone) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + ", name=" + name + ", ssn=" + ssn + ", phone=" + phone + ", address="
				+ address + "]";
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
