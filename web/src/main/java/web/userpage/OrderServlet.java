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
		
		ArrayList<Order> cartlist = new ArrayList();
		OrderDAO dao = new OrderDAO();
		cartlist = dao.getOrderList();
		
		req.setAttribute("cartlist", cartlist);
		
		
		req.getRequestDispatcher("WEB-INF/views/orderlist.jsp").forward(req, resp);
		
		
	}
	
}
