package web.review;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.model.User;
@WebServlet("/addReview")
public class AddReviewServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		 resp.setCharacterEncoding("UTF-8");
	        resp.setContentType("text/html;charset=utf-8");

	        // 세션에서 로그인 상태 확인
	        HttpSession session = req.getSession(false); // 기존 세션 가져오기
	        //세션이 존재할 경우 로그인 한 사용자의 id 를 가져오기
	        User currentUser  = (session != null) ? (User) session.getAttribute("currentUser") : null;

	        if (currentUser != null) {
	        	// 사용자의 제품 번호 및 아이템 번호 목록 가져오기
	            ReviewService service = new ReviewService();
	            ArrayList<Review> productItems = service.getOrderItemsByUserId(currentUser.getId());
	           
	            
	            req.setAttribute("productItems", productItems);
	            req.setAttribute("currentUserId", currentUser.getId());
	            
	            // 회원인 경우, 새 글 작성 페이지로 이동
	            req.getRequestDispatcher("WEB-INF/views/reviewAdd.jsp").forward(req, resp);
	        } else {
	            // 비회원인 경우, 경고 메시지와 함께 리뷰 메인 페이지로 리다이렉트
	            String message = URLEncoder.encode("로그인이 필요합니다.", "utf-8");
	            resp.sendRedirect("/web/review?message=" + message);
	        }
	    }

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		 // 세션에서 사용자 ID 가져오기
        HttpSession session = req.getSession(false);
        User currentUser = (session != null) ? (User) session.getAttribute("currentUser") : null;

        if (currentUser != null) {
            // 리뷰 데이터 가져오기
            String productNo = req.getParameter("product_no");
            String itemNo = req.getParameter("item_no");
            String contents = req.getParameter("contents");
            String rating = req.getParameter("rating");

            // Review 객체 생성
            Review review = new Review();
            review.setUser(currentUser); // 사용자 객체 설정
            review.setProduct_no(Integer.parseInt(productNo)); // product_no는 int로 변환
            review.setItem_no(itemNo);
            review.setContents(contents);
            review.setRating(rating);

            // 리뷰 추가 서비스 호출
            ReviewService service = new ReviewService();
            int result = service.addReview(session, review); // 세션도 함께 전달

            if (result > 0) {
                // 리뷰 추가 성공 시, 리뷰 목록 페이지로 리다이렉트
                resp.sendRedirect("/web/review?p=1");
            } else {
                // 리뷰 추가 실패 시, 에러 메시지 처리 (선택 사항)
                String message = URLEncoder.encode("리뷰 추가에 실패했습니다.", "UTF-8");
                resp.sendRedirect("/web/review?message=" + message);
            }
        } else {
            // 로그인하지 않은 경우
            String message = URLEncoder.encode("로그인이 필요합니다.", "UTF-8");
            resp.sendRedirect("/web/review?message=" + message);
        }
    }
}