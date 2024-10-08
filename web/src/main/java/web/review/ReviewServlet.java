package web.review;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/review")
public class ReviewServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ReviewService service = new ReviewService();
		ArrayList<Review> allList = service.getReviewAll();
		
		req.setAttribute("allList", allList);
		req.getRequestDispatcher("WEB-INF/views/review.jsp").forward(req, resp);
		
		
	}
}
