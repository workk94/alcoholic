package web.admin;

import java.util.ArrayList;

public class AdminService {
	AdminDAO dao = new AdminDAO();
	
	
	public ArrayList<Admin> getAdminList(){
		return dao.selectAll();
	}
	
	public Admin getAdminDetail(String id) {
		return dao.selectOne(id);
	}
	
	public int updateAdmin(Admin admin) {
		return dao.update(admin);
	}
	public int deleteAdmin(String id) {
		return dao.delete(id);
	}
}
