package web.userpage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/addcart")
public class AddCartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String code = req.getParameter("code");		
		
		
		System.out.println( code);
		
		
		ProductDAO dao = new ProductDAO();
		Product product = new Product();
		product = dao.selectOne(code);
		
		
		System.out.println("dfdfd" + product);
		
		
		
		HttpSession session = req.getSession();
		
//		카트에 null 값이 들어가면 초기화하기 위한 remove		
//		session.removeAttribute("cartlist");
		
		Object result = session.getAttribute("cartlist");
		
		if(result !=null) {
			
			ArrayList<Product> cartlist =  (ArrayList<Product>) result;
			cartlist.add(product);
		} else {
			ArrayList<Product> cartlist = new ArrayList<Product>();
			cartlist.add(product);				
			session.setAttribute("cartlist", cartlist);
		}
		
		
		resp.sendRedirect("/web/cart");
		
//		req.getRequestDispatcher("WEB-INF/views/cartlist.jsp").forward(req, resp);
		
	}
	
}
