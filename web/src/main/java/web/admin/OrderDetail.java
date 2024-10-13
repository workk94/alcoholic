package web.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin_order.detail")
public class OrderDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OrderService s = new OrderService();

		String no = req.getParameter("no");
		ArrayList<Order> order = s.getOrderDetail(no);

		req.setAttribute("order", order);

		req.getRequestDispatcher("WEB-INF/views/admin_order_detail.jsp").forward(req, resp);
	}
}
