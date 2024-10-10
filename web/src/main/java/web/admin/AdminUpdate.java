package web.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin.update")
public class AdminUpdate extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		
		Admin admin = new Admin(id, pw, null, null, phone, address);
		
		AdminService s = new AdminService();
		s.updateAdmin(admin);
		
		ArrayList<Admin> list = s.getAdminList();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/admin.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AdminService s = new AdminService();
		
		
		String id = req.getParameter("id");
		Admin admin = s.getAdminDetail(id);
		
		req.setAttribute("admin", admin);
		
		req.getRequestDispatcher("WEB-INF/views/admin_update.jsp").forward(req, resp);
		
		
		
	}
}
