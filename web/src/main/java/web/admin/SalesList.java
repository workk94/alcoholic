package web.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin_sales")
public class SalesList extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SalesService s = new SalesService();
		
		ArrayList<Sales> dailySales = s.getDailySales();
		req.setAttribute("dailySales", dailySales);
		
		ArrayList<Sales> salesByItem = s.getSalesByItem();
		req.setAttribute("salesByItem", salesByItem);
		
		ArrayList<Sales> salesByCategory = s.getSalesByCategory();
		req.setAttribute("salesByCategory", salesByCategory);
		
		
		req.getRequestDispatcher("WEB-INF/views/admin_sales.jsp").forward(req, resp);
		
		
	}

}
