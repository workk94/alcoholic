package web.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin_product.add")
public class ProductAdd extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String category = req.getParameter("category");
		String priceParam = req.getParameter("price"); // 가격을 String으로 가져옵니다.
		int price = Integer.parseInt(priceParam); // String을 int로 변환합니다.
		String imgUrl = req.getParameter("imgUrl");
		
		Product product = new Product(null, name, category, price, imgUrl);
		
		ProductService s = new ProductService();
		s.addProduct(product);

		ArrayList<Product> list = s.getProductList();

		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/admin_product.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("WEB-INF/views/admin_product_add.jsp").forward(req, resp);
	}
}
