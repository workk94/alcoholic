package web.login;

public class User {
	private String id;
	private String pw;
	private String name;
	private String ssn;
	private String phone;
	private String addr;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String id, String pw, String name, String ssn, String phone, String addr) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.addr = addr;
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + ", name=" + name + ", ssn=" + ssn + ", phone=" + phone + ", addr="
				+ addr + "]";
	}
}
