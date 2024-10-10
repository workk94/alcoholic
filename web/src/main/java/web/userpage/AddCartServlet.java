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
	
//		session.removeAttribute("cartlist");
		
		Object result = session.getAttribute("cartlist");
		
		if(result !=null) {
			
			System.out.println("  세션있는 경우");
			
			ArrayList<Product> cartlist =  (ArrayList<Product>) result;
			cartlist.add(product);
		} else {
			
			System.out.println("  세션있는  없는 경우");
			ArrayList<Product> cartlist = new ArrayList<Product>();
			cartlist.add(product);				
			session.setAttribute("cartlist", cartlist);
		}
		
		// 상품 정보를 세션에 저장
      
		
		req.getRequestDispatcher("WEB-INF/views/cartlist.jsp").forward(req, resp);
		
	}
	
}
