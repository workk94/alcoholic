package web.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class DeleteReview extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String review_no = req.getParameter("review_no");
		
		ReviewService service = new ReviewService();
		service.deleteReview(review_no);
		
		resp.sendRedirect("/web/review");
	
	}
}
