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
            Review review = new Review(currentUser, productNo, itemNo, contents, rating);

            // 리뷰 추가 서비스 호출
            ReviewService service = new ReviewService();
            service.addReview(review);

            // 리뷰 목록 페이지로 리다이렉트
            resp.sendRedirect("/web/review?p=1");
        } else {
            // 로그인하지 않은 경우
            String message = URLEncoder.encode("로그인이 필요합니다.", "UTF-8");
            resp.sendRedirect("/web/review?message=" + message);
        }
    }
}
