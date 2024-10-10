package web.userpage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/order")
public class OrderServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<Order> list = new ArrayList();
		OrderDAO dao = new OrderDAO();
		list = dao.getOrderList();
		
		req.setAttribute("list", list);
		
		
		req.getRequestDispatcher("WEB-INF/views/orderlist.jsp").forward(req, resp);
		
	}
	
}
