package web.review;

import web.model.User;

public class Review {

	//review_no, user_id, product_no, item_no, contents, rating,  created_at
	//리뷰번호		 사용자 id	 제품번호	 	 아이템번호	리뷰내용	  평점		  작성시간
	//상품테이블	 고객테이블	 주문아이템	  주문아이템					
	
	int review_no;	//1
	 User user;           // User 객체
	String user_id;			//6
	int product_no;	//2
	String item_no;		//3
	String contents;	//4
	String rating;		//5
	String created_at;	//7

	public Review() {
		// TODO Auto-generated constructor stub
	}
	
	


	public Review(int review_no,User user, int product_no, String item_no, String contents, String rating,
			String created_at) {
		
		this.review_no = review_no;
		this.user = user;
	    this.user_id = user != null ? user.getId() : null; // 사용자 ID 설정
		this.product_no = product_no;
		this.item_no = item_no;
		this.contents = contents;
		this.rating = rating;
		this.created_at = created_at;
	}

	//userId, productNo, itemNo, contents, rating
	
	public Review(User user, int product_no, String item_no, String contents, String rating) {
		this.user = user;
		this.user_id = user != null ? user.getId() : null; // 사용자 ID 설정
		this.product_no = product_no;
		this.item_no = item_no;
		this.contents = contents;
		this.rating = rating;
	}
	

//	@Override
//	public String toString() {
//		return "Review [review_no=" + review_no + ", user_id=" + id + ", product_no=" + product_no + ", item_no="
//				+ item_no + ", contents=" + contents + ", rating=" + rating + ", created_at=" + created_at + "]";
//	}




	@Override
	    public String toString() {
	        return "Review [review_no=" + review_no + ", user_id=" + user_id  + 
	               ", product_no=" + product_no + ", item_no=" + item_no + ", contents=" + contents + 
	               ", rating=" + rating + ", created_at=" + created_at + "]";
	    }

	public int getReview_no() {
		return review_no;
	}


	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}



    
    
    //
	public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        this.user_id = user != null ? user.getId() : null; // User가 변경될 때 user_id 업데이트
    }

    public String getUser_id() {
        return user_id;
    }


	
    public int getProduct_no() {
        return product_no;
    }


	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}


	public String getItem_no() {
		return item_no;
	}


	public void setItem_no(String item_no) {
		this.item_no = item_no;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getCreated_at() {
		return created_at;
	}


	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}


	//review_no, user_id, product_no, item_no, contents, rating, created_at
	 public static void main(String[] args) {
	        User user = new User(); // User 객체 생성
	        user.setId("6"); // 사용자 ID 설정
	        Review r = new Review(1, user, 2, "3", "This is a review.", "5", "2024-10-14");
	        System.out.println(r); // Review 객체 출력
	    }
	}