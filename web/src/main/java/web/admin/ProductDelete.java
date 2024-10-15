package web.admin;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin_product.delete")
public class ProductDelete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");

		
		ProductService s = new ProductService();
		try {
			s.deleteProduct(no);
			resp.sendRedirect("/web/admin_product");
		} catch (SQLIntegrityConstraintViolationException e) {
			req.setAttribute("message", "해당 상품은 삭제가 불가능합니다! (주문내역 존재)");
			ArrayList<Product> list = s.getProductList();
			req.setAttribute("list", list);
			req.getRequestDispatcher("WEB-INF/views/admin_product.jsp").forward(req, resp);
			e.printStackTrace();
		}

		

	}
}
