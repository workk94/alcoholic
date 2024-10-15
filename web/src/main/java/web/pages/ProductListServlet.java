package web.pages;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.model.ShopService;


@WebServlet("/list")
public class ProductListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String category = req.getParameter("category");
		
		category = category.toUpperCase();
		
		ShopService service = new ShopService();
		
		ArrayList<ProductDTO> list = service.getProductByCat(category);
		
		
		req.setCharacterEncoding("utf-8");
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/list.jsp").forward(req, resp);
	}
}
