package web.review;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/review")
public class ReviewServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ReviewDAO dao = new ReviewDAO();
		ReviewService service = new ReviewService();
		
		// 세션을 가져와서 사용자 ID를 확인
	    HttpSession session = req.getSession(false); // 세션이 없을 경우 null을 반환
	    String currentUserId = (session != null) ? (String) session.getAttribute("user_id") : null;
		
		
		int pageSize = 5;
		int grpSize = 5;
		int currentPage =1;
		// 쿼리 파라미터에서 페이지 번호와 검색 조건 가져오기
		String p_ = req.getParameter("p");
		 // 검색 관련 파라미터 가져오기
        String searchType = req.getParameter("searchType");
        String searchQuery = req.getParameter("searchQuery");
        
		if(p_ != null) {
			currentPage = Integer.parseInt(p_);
		}
		
		ArrayList<Review> allList;
		int totRecords;
        
		if (searchQuery != null && !searchQuery.isEmpty()) {
	        // 검색 기능
	        allList = dao.searchReviews(searchType, searchQuery, currentPage, pageSize);
	        // 총 레코드 수는 별도로 계산
	        totRecords = dao.getSearchTotalCount(searchType, searchQuery);
        } else {
            // 총 레코드 수 가져오기
        	totRecords = service.recordCnt();
            
            // 현재 페이지에 해당하는 리뷰 목록 가져오기
            allList = dao.listPaging(currentPage, pageSize);
        }
		

		Paging paging = new Paging(pageSize,grpSize, totRecords,currentPage);
		


		req.setAttribute("allList", allList);
		System.out.println(allList);
		req.setAttribute("paging", paging);
		req.setAttribute("totalCount", totRecords); // 전체 리뷰 수 설정
	    req.setAttribute("currentUserId", currentUserId); // 사용자 ID를 JSP로 전달

		req.getRequestDispatcher("WEB-INF/views/review.jsp").forward(req, resp);
	}
	}