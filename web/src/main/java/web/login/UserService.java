package web.login;

import java.util.ArrayList;

public class UserService {
	UserDAO dao = new UserDAO();
	
	public User userLogin(String id, String pw) {
		return dao.findByIdAndPassword(id, pw);
	}
	
	public int userReg(User user) {
		return dao.insertUser(user);
	}
}
