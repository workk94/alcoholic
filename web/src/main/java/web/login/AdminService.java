package web.login;

public class AdminService {
	AdminDAO dao = new AdminDAO();
	
	public AdminDTO adminLogin(String id, String pw) {
		return dao.findByIdAndPassword(id, pw);
	}
}
