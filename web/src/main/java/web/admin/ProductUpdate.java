package web.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin_product.update")
public class ProductUpdate extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String no = req.getParameter("no");
		String name = req.getParameter("name");
		String priceParam = req.getParameter("price"); // 가격을 String으로 가져옵니다.
		int price = Integer.parseInt(priceParam); // String을 int로 변환합니다.
		String imgUrl = req.getParameter("imgUrl");
	
		
		Product product = new Product(no, name, null, price, imgUrl);

		ProductService s = new ProductService();
		s.updateProduct(product);

		ArrayList<Product> list = s.getProductList();

		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/admin_product.jsp").forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductService s = new ProductService();
		
		String no = req.getParameter("no");
		Product product = s.getProductDetail(no);
		
		req.setAttribute("product", product);
		req.getRequestDispatcher("WEB-INF/views/admin_product_update.jsp").forward(req, resp);
	}
}
