package web.login;

public class AdminDTO {
	private String id;
	private String pw;
	private String name;
	
	public AdminDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public AdminDTO(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
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

	@Override
	public String toString() {
		return "AdminDTO [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}
	
	
}
