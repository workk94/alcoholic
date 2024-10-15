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
public class SearchServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyword = req.getParameter("s_keword");
		
		ShopService service = new ShopService();
		ArrayList<ProductDTO> list = service.searchProductList(keyword);
		
		
		req.setCharacterEncoding("utf-8");
		req.setAttribute("searchList", list);
		req.getRequestDispatcher("WEB-INF/views/search.jsp").forward(req, resp);
	}
}
