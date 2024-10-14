package web.pages;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.model.ShopService;



@WebServlet("/main")
public class MainServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ShopService service  = new ShopService();
		
		ArrayList<ProductDTO> productList = service.getAllProduct();
		
		req.setAttribute("productList", productList);
		req.getRequestDispatcher("WEB-INF/views/main.jsp").forward(req, resp);
		
	}
}
