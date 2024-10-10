package web.pages;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/shop")
public class ShopServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String productNo = req.getParameter("product_no");
		ShopService service = new ShopService();
		ProductDTO product = service.getProduct(productNo);
		
		req.setCharacterEncoding("utf-8");
		req.setAttribute("product", product);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/views/shop.jsp");
		dispatcher.forward(req, resp);
	}
}
