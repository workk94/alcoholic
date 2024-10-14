package web.pages;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.model.ShopService;

@WebServlet("/shop")
public class ShopServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String productNo = req.getParameter("product_no");
		
		HttpSession session = req.getSession();
		Object userCart = session.getAttribute("cartlist");
		ArrayList<ProductDTO> cartList = null;
		
		if(userCart != null) {
			cartList = (ArrayList<ProductDTO>) userCart;
		}
		
		ShopService service = new ShopService();
		ProductDTO product = service.getProduct(productNo);
		
		req.setCharacterEncoding("utf-8");
		req.setAttribute("product", product);
		req.setAttribute("cartlist", cartList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/views/shop.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
