package web.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin_product")
public class ProductList extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductService s = new ProductService();
		ArrayList<Product> list = s.getProductList();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/admin_product.jsp").forward(req, resp);
		
		
	}

}
