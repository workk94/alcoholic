package web.userpage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/product")
public class ProductServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		ProductDAO dao = new ProductDAO();
		ArrayList<Product> list = new ArrayList();
		
		list = dao.prodList();
		
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("WEB-INF/views/prodlist.jsp").forward(req, resp);
		
	}
	
}
