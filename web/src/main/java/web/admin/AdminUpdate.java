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
		
		int pageSize = 10;
		int grpSize = 5;

		int totRecords = 90;
		int currentPage = 1;

		String p_ = req.getParameter("p");
		if (p_ != null) {
			currentPage = Integer.parseInt(p_);
		}
		
		totRecords = s.getTotalCnt();

		ArrayList<Admin> list = s.getPage(currentPage, pageSize);

		PageHandler pageHandler = new PageHandler(pageSize, grpSize, totRecords, currentPage);
		
		
		req.setAttribute("handler", pageHandler);
		
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
