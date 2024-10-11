package web.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/adminlogin")
public class AdminLoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/adminlogin.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		
		String admin_id = req.getParameter("admin_id");
		String admin_pw = req.getParameter("admin_pw");

		AdminService service = new AdminService();
		AdminDTO admin = service.adminLogin(admin_id, admin_pw);

		if (admin != null) {
			// 바꿔야됨
			resp.sendRedirect(req.getContextPath() + "/admin");
		} else {
			resp.sendRedirect(req.getContextPath() + "/adminlogin");
		}
	}
}
