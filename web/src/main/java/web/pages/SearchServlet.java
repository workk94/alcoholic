package web.pages;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.model.ShopService;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String keyword = req.getParameter("s_keyword");
		System.out.println(keyword);
		
		keyword = keyword.toUpperCase();
		
		ShopService service = new ShopService();
		ArrayList<ProductDTO> list = service.searchProductList(keyword);
		System.out.println(list);
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/search.jsp").forward(req, resp);
	}
}
