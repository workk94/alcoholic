package web.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin")
public class AdminList extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AdminService s = new AdminService();
		ArrayList<Admin> list = s.getAdminList();
		
		req.setAttribute("list", list);
		
		
		req.getRequestDispatcher("WEB-INF/views/admin.jsp").forward(req, resp);
		
	}

}
