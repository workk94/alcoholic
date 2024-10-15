package web.review;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public class ReviewService {

ReviewDAO dao = new ReviewDAO();
	
	//리뷰 전체조회 
	public ArrayList<Review> getReviewAll(){
		return dao.listPaging(1, 2);
	}
	
	//전체리뷰 수
	public int recordCnt() {
		return dao.selectTotalCnt();
	}
	
	//리뷰상세조회
	public Review getReview(int review_no) {
		return dao.selectOne(review_no);
	}

	 // 리뷰 추가
    public int addReview(HttpSession session, Review review) {
        return dao.addReview(session, review);
    }

	// 리뷰 수정
	public int updateReview(Review review) {
		return dao.update(review);
	}
	// 리뷰 삭제
	public int deleteReview(String review_no) {
		return dao.delete(review_no);
	}
	
	 // 구매한 제품 가져오기
    public ArrayList<Review> getOrderItemsByUserId(String userId) {
        return dao.getOrderItemsByUserId(userId);
    }

    // 검색 기능
    public ArrayList<Review> searchReviews(String searchType, String searchQuery, int currentPage, int pageSize) {
        return dao.searchReviews(searchType, searchQuery, currentPage, pageSize);
    }

    // 검색된 총 레코드 수
    public int getSearchTotalCount(String searchType, String searchQuery) {
        return dao.getSearchTotalCount(searchType, searchQuery);
    }
}