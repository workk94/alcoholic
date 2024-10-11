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
	    System.out.println(code);

	    ProductDAO dao = new ProductDAO();
	    Product product = dao.selectOne(code);
	    System.out.println("dfdfd" + product);

	    HttpSession session = req.getSession();
	    Object result = session.getAttribute("cartlist");
	    boolean exist = false;

	    if (result != null) {
	        // 카트가 비어있지 않다면
	        ArrayList<Product> cartlist = (ArrayList<Product>) result;

	        for (Product p : cartlist) {
	            if (p.getProd_no().equals(code)) {
	                exist = true;
	                System.out.println("같은 제품이 있음");
	                break; // 중복된 제품이 있으면 루프 종료
	            }
	        }

	        // 루프 종료 후 exist 확인
	        if (!exist) {
	            cartlist.add(product);
	            System.out.println("들어감");
	        }
	        
	    } else {
	        // 카트가 비어있다면
	        ArrayList<Product> cartlist = new ArrayList<Product>();
	        cartlist.add(product);
	        session.setAttribute("cartlist", cartlist);
	    }

	    resp.sendRedirect("/web/cart");
	}
	
}
