package web.userpage;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/updatecart")
public class UpdateCartServlet extends HttpServlet {
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 현재 세션에서 장바구니 가져오기
        HttpSession session = request.getSession();
        ArrayList<Product> cartlist = (ArrayList<Product>) session.getAttribute("cartlist");
        ProductDAO dao = new ProductDAO();
        
        
        if (cartlist != null) {
            // 제품 수량 업데이트
            for (Product product : cartlist) {
                String quantityParam = request.getParameter("quantity_" + product.getProd_no());
                
                if (quantityParam != null) {
                    try {
                        int quantity = Integer.parseInt(quantityParam);
                        // 수량이 0보다 작지 않도록 확인
                        if (quantity > 0) {
                        	  // 데이터베이스에 수량 업데이트
                            dao.UpdateOrderItem(product.getProd_no(), quantity);
                            product.setQuantity(quantity); // Product 클래스에 setQuantity 메서드가 있어야 함
                        } else {
                            // 수량이 0이면 장바구니에서 삭제
                            cartlist.remove(product);
                        }
                    } catch (NumberFormatException e) {
                        // 수량 파싱 오류 처리 (예: 숫자가 아닐 경우)
                        e.printStackTrace();
                    }
                }
            }
        }

        // 장바구니를 다시 세션에 저장
        session.setAttribute("cartlist", cartlist);
        
        

        // 장바구니 페이지로 리다이렉트
        response.sendRedirect(request.getContextPath() + "/order");
    
    }
}
