package web.userpage;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ordercreate")
public class OrderCreateServlet extends HttpServlet {
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 현재 세션에서 장바구니 가져오기
    	  
        int quantity=   Integer.parseInt( request.getParameter("quantity"));
        String code= request.getParameter("code");
        
      
        //주문번호 발생 
        //주문정보 생성   insert 
        //주무아이템 생성   insert
        
        OrderDAO order =new OrderDAO();
        
        int orderseq = order.selectseqenceNo();        
        order.InsertOrder("rlaanrnd", orderseq);
        order.insertOrderItem(orderseq, code, quantity);
        		
         
        
        
        //세션 삭제, 장바구니 삭제
    	 deleteSession( request , code);       

        // 장바구니 페이지로 리다이렉트
        response.sendRedirect(request.getContextPath() + "/order");
    
    }
    
    
    
    public void deleteSession(  HttpServletRequest   request , String code) {
    	
        HttpSession session = request.getSession();
        ArrayList<Product> cartlist = (ArrayList<Product>) session.getAttribute("cartlist");
      
        
        
        Product  search=null;
        if (cartlist != null) {
            // 제품 수량 업데이트
            for (Product product : cartlist) {
                 
                      if( product.getProd_no().equals(code))   {
                    	  search =product;
                    	   
                   }
            }            
            
            cartlist.remove(search); 
            
            System.out.println("삭제후 ==>") ;
            
            System.out.println( cartlist);
            
          
        }
    
    }
}
