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
		
		int pageSize =3;
		int grpSize = 5;
		int totRecords =0;
		int currentPage =1;
		
		String p_ = req.getParameter("p");
		if(p_ != null) {
			currentPage = Integer.parseInt(p_);
		}
		ReviewDAO dao = new ReviewDAO();
		totRecords = dao.selectTotalCnt();
		
		
		ReviewService service = new ReviewService();
		//ArrayList<Review> allList = service.getReviewAll();
		ArrayList<Review> allList = dao.listPaging(currentPage, pageSize);
		
		Paging paging = new Paging(pageSize,grpSize,totRecords,currentPage);
		
		req.setAttribute("allList", allList);
		req.setAttribute("paging", paging);
		req.getRequestDispatcher("WEB-INF/views/review.jsp").forward(req, resp);
		
		
	}
}
