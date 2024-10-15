package web.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/reviewOne")
public class ReviewOneServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		// 세션을 가져와서 사용자 ID를 확인
	    HttpSession session = req.getSession(false); // 세션이 없을 경우 null을 반환
	    String currentUserId = (session != null) ? (String) session.getAttribute("user_id") : null;
		 
	    String reviewNoStr = req.getParameter("review_no");
	    int reviewNo = Integer.parseInt(reviewNoStr); // String을 int로 변환
		
		ReviewService service = new ReviewService();
		Review reviewOne = service.getReview(reviewNo);
		req.setAttribute("reviewOne", reviewOne);
		req.getRequestDispatcher("WEB-INF/views/reviewOne.jsp").forward(req, resp);
	}
}
