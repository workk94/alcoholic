package web.login;

import java.util.ArrayList;

public class UserService {
	UserDAO dao = new UserDAO();
	
	public User userLogin(String id, String pw) {
		return dao.findByIdAndPassword(id, pw);
	}
}
