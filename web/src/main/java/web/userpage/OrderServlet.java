package web.userpage;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.model.User;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		ArrayList<Order> cartlist = new ArrayList();
		OrderDAO dao = new OrderDAO();
		User loginUser = (User) session.getAttribute("currentUser");

		String loginId = "";

		if (loginUser != null) {
			loginId = loginUser.getId();

		}
		
		
		cartlist = dao.getOrderList(loginId);

		req.setAttribute("cartlist", cartlist);

		req.getRequestDispatcher("WEB-INF/views/orderlist.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
