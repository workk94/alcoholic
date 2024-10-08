package web.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin.update")
public class AdminUpdate extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AdminService s = new AdminService();
		
		
		String id = req.getParameter("id");
		Admin admin = s.getAdminDetail(id);
		
		req.setAttribute("admin", admin);
		
		req.getRequestDispatcher("WEB-INF/views/update.jsp").forward(req, resp);
		
		
		
	}
}
