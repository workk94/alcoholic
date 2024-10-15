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
public class AddCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String qty_ = req.getParameter("qty");

        int qty = Integer.parseInt(qty_);

        ProductDAO dao = new ProductDAO();
        Product product = dao.selectOne(code);

        HttpSession session = req.getSession();
        Object result = session.getAttribute("cartlist");

        ArrayList<Product> cartlist;
        boolean exist = false;

        if (result != null) {
            cartlist = (ArrayList<Product>) result;

            // 이미 장바구니에 있는 경우 : 상품수량을 추가함
            for (Product p : cartlist) {
                if (p.getProd_no().equals(code)) {
                    exist = true;
                    int newQty = p.getQuantity() + qty; 
                    p.setQuantity(newQty);  
                    break;
                }
            }

            if (!exist) {
                // 장바구니에 없으면 새로운 상품 추가
                product.setQuantity(qty); 
                cartlist.add(product);
                System.out.println("상품이 장바구니에 추가됨");
            }

        } else {
            // 카트가 비어있을 경우
            cartlist = new ArrayList<Product>();
            product.setQuantity(qty);
            cartlist.add(product);
            session.setAttribute("cartlist", cartlist);
            System.out.println("새로운 장바구니 생성 및 상품 추가");
        }

        resp.sendRedirect("/web/cart");
    }
}
