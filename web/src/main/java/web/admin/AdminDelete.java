package web.admin;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin.delete")
public class AdminDelete extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		AdminService s = new AdminService();
		try {
			s.deleteAdmin(id);
			resp.sendRedirect("/web/admin");
		} catch (SQLIntegrityConstraintViolationException e) {
			int pageSize = 10;
			int grpSize = 5;
	
			int totRecords = 90;
			int currentPage = 1;
	
			String p_ = req.getParameter("p");
			if (p_ != null) {
				currentPage = Integer.parseInt(p_);
			}
				totRecords = s.getTotalCnt();
				
			req.setAttribute("message", "해당 계정은 삭제가 불가능합니다! (주문내역 존재)");
			ArrayList<Admin> list = s.getPage(currentPage, pageSize);
			PageHandler pageHandler = new PageHandler(pageSize, grpSize, totRecords, currentPage);
			req.setAttribute("list", list);
			req.setAttribute("handler", pageHandler);
			req.getRequestDispatcher("WEB-INF/views/admin.jsp").forward(req, resp);
			e.printStackTrace();
		}

	
		
	}
}
