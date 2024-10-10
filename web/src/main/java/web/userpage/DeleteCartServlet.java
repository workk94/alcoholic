package web.userpage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/deletecart")
public class DeleteCartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String code = req.getParameter("code");
		
		HttpSession session = req.getSession();
		Object result = session.getAttribute("cartlist");
		
		if(result !=null) {
			
			ArrayList<Product> cartList = (ArrayList<Product>) result;
			
			int removeNum = 0;
			for(int i=0; i<cartList.size(); i++) {
				if(cartList.get(i).getProd_no().equals(code)) {
					removeNum = i;
					break;
				}
			}
			
			cartList.remove(removeNum);
		}
		
		resp.sendRedirect("/web.userpage/cart");
	}
	
}
