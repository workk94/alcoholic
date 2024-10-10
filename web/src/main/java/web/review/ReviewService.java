package web.review;

import java.util.ArrayList;

public class ReviewService {

	ReviewDAO dao = new ReviewDAO();
	
//	//리뷰 전체조회 
//	public ArrayList<Review> getReviewAll(){
//		return dao.selectAllReview();
//	}

	//리뷰 전체조회 
	public ArrayList<Review> getReviewAll(){
		return dao.listPaging(1, 2);
	}	
	
	
	//리뷰상세조회
	public Review getReview(String review_no) {
		// 필요한 속성으로 Review 객체 생성
		Review review = dao.selectOne(review_no);
		return review;
	}

	// 리뷰 추가
	public void addReview(Review review) {
		dao.addReview(review);
	}

	// 리뷰 수정
	int updateReview(Review review) {
		return dao.update(review);
	}

	// 리뷰 삭제
	public void deleteReview(String review_no) {
		dao.delete(review_no);
	}
}
