package web.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin_order")
public class OrderList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OrderService s = new OrderService();
		ArrayList<Order> list = s.getOrderList();

		req.setAttribute("list", list);

		req.getRequestDispatcher("WEB-INF/views/admin_order.jsp").forward(req, resp);

	}
}
