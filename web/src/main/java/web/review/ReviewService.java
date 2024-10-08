package web.review;

import java.util.ArrayList;

public class ReviewService {

	ReviewDAO dao = new ReviewDAO();
	
	//리뷰 전체조회 
	public ArrayList<Review> getReviewAll(){
		return dao.selectAllReview();
	}
	
	//리뷰상세조회
	public Review getReview(String review_no) {
		Review review = dao.selectOne(review_no);
		return review;
	}
	
	
}
