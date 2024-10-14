package web.model;

public class UserService {
	UserDAO dao = new UserDAO();
	
	public User userLogin(String id, String pw) {
		return dao.findByIdAndPassword(id, pw);
	}
	
	public int userReg(User user) {
		return dao.insertUser(user);
	}
	
	public boolean isUserExist(String id) {
	    return dao.selectId(id) != -1;
	}
	
	
	//test
	public static void main(String[] args) {
		UserService service = new UserService();
		
		boolean result = service.isUserExist("zz");
		
		System.out.println(result);
	}
}
