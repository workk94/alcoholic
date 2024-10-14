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
		
		int pageSize = 10;
		int grpSize = 5;

		int totRecords = 90;
		int currentPage = 1;

		String p_ = req.getParameter("p");
		if (p_ != null) {
			currentPage = Integer.parseInt(p_);
		}

		AdminService s = new AdminService();
		
		totRecords = s.getTotalCnt();

		ArrayList<Admin> list = s.getPage(currentPage, pageSize);

		PageHandler pageHandler = new PageHandler(pageSize, grpSize, totRecords, currentPage);
		
		
		req.setAttribute("handler", pageHandler);
		
		req.setAttribute("list", list);
		
		
		req.getRequestDispatcher("WEB-INF/views/admin.jsp").forward(req, resp);
		
	}

}
