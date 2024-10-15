package web.review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import web.model.User;
import web.userpage.Order;

public class ReviewDAO {

	// DB 연결 정보
	   private String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	   private String user = "scott";
	   private String password = "tiger";

	   // DB 연결 메서드 (드라이버 로드 및 DB 연결)
	   private Connection dbcon() throws SQLException {
	   Connection con = null;
	       try {
	           Class.forName("oracle.jdbc.driver.OracleDriver");
	           con = DriverManager.getConnection(url, user, password);
	           if(con != null) System.out.println("db connected");
	       } catch (ClassNotFoundException e) {
	           e.printStackTrace();
	       }
	       return con;
	   }

	   
	   //페이징 전체 리스트 구하기 ArrayList<Review>
	   public ArrayList<Review> listPaging(int currentPage, int pageSize){	//1page 에 10 개  
		   Connection con  = null;
		   PreparedStatement pst = null;
		   ResultSet rs = null;
		   
		   int start = (currentPage - 1) * pageSize;
		   int end =currentPage * pageSize;
			  ArrayList<Review> list = new ArrayList<>();

			  String sql = "SELECT * FROM ( "
			           + "SELECT review_no, user_id, product_no, item_no, contents, rating, created_at, "
			           + "ROWNUM as rnum FROM ( "
			           + "SELECT review_no, user_id, product_no, item_no, contents, rating, created_at "
			           + "FROM reviewtbl "
			           + "ORDER BY TO_NUMBER(review_no) DESC) "
			           + ") "
			           + "WHERE rnum > ? AND rnum <= ?";
		   try {
			con = dbcon();
			pst = con.prepareStatement(sql);
			pst.setInt(1, start);
			pst.setInt(2, end);
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				int review_no = rs.getInt("review_no");
                String user_id = rs.getString("user_id");
                int product_no = rs.getInt("product_no");
                String item_no = rs.getString("item_no");
                String contents = rs.getString("contents");
                String rating = rs.getString("rating");
                String created_at = rs.getString("created_at");
				 // User 객체 생성 및 초기화
	            User user = new User();
	            user.setId(user_id); // 사용자 ID 설정
				
				Review review = new Review(review_no, user, product_no ,item_no,contents,rating, created_at);
				list.add(review);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(con, pst, rs);
		}
		   return list;
	   }
	   
	   
	   
	   //전체레코드 수 구하기 
	   public int selectTotalCnt() {
			
			Connection con = null;
			PreparedStatement pst =null;
			ResultSet rs =null;
			String sql = "select count(*) from reviewtbl";	// 전체레코드 수 구하기
			int rowTotalCnt=0;
			
			try {
				con = dbcon();
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();
				if(rs.next()) {
					rowTotalCnt = rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(con, pst, rs);
			}
			return rowTotalCnt;
		}
	   
	   
	 //리뷰 상세 조회
	   public Review selectOne(int review_no) {
		
		   Review review = null;
		   String sql = "select * from reviewtbl where review_no=?";
		   Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
		   
		   try {
			con = dbcon();
			pst =con.prepareStatement(sql);
			pst.setInt(1, review_no);
			rs = pst.executeQuery();
			
			if (rs.next()) {
                String user_id = rs.getString("user_id");
                int product_no = rs.getInt("product_no");
                String item_no = rs.getString("item_no");
                String contents = rs.getString("contents");
                String rating = rs.getString("rating");
                String created_at = rs.getString("created_at");
				
				 // User 객체 생성 및 초기화
	            User user = new User();
	            user.setId(user_id); // 사용자 ID 설정
				review = new Review(review_no, user,  product_no, item_no, contents, rating, created_at);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
      close(rs, pst, con);
  }
		   return review;
	   }
	   
	   
	   
	// 상세조회 한 뒤 수정 가능 => 수정하면 update 
	   public int update (Review review){
		   int row = 0;
		   Connection con =null;
		   PreparedStatement pst =null;
						//update  reviewtbl set  contents ='하이' where review_no = '1';
		   String sql ="update  reviewtbl set  contents =?, rating=?  where review_no= ? ";
		   try {
			con = dbcon();
			pst = con.prepareStatement(sql);
  
			pst.setString(1, review.getContents());
			pst.setString(2, review.getRating());
			pst.setInt(3, review.getReview_no());
			
	        row =pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	        close(pst, con);  // 연결 종료는 finally 블록에서 수행
	    }
		   return row;
	   }

	
/*
	   //리뷰추가
	   public int addReview(Review review) {
		   int row = 0;
		    String sql = "INSERT INTO reviewtbl (review_no, user_id, product_no, item_no, contents, rating, created_at) VALUES (review_no_seq.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE)";
		    Connection con = null;
		    PreparedStatement pst = null;
		    try {
		    	con = dbcon();
		    	pst = con.prepareStatement(sql);
		    
		        pst.setString(1, review.getUser_id());
		        pst.setString(2, review.getProduct_no());
		        pst.setString(3, review.getItem_no());
		        pst.setString(4, review.getContents());
		        pst.setString(5, review.getRating());

		        row = pst.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        close(pst, con); 
		    } return row;
	   }
*/
	   //리뷰추가
	   public int addReview(HttpSession session, Review review) {
		    int row = 0;
		    String sql = "INSERT INTO reviewtbl (review_no, user_id, product_no, item_no, contents, rating, created_at) " +
		                 "VALUES (review_no_seq.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE)";

		    Connection con = null;
		    PreparedStatement pst = null;

		    // 로그인 확인
		    if (review.getUser() == null) {
		        throw new IllegalArgumentException("로그인 후 리뷰를 작성해주세요.");
		    }

		    String loggedInUserId = review.getUser().getId(); // 현재 사용자 ID 가져오기

		    // DB에 리뷰 추가
		    try {
		        con = dbcon();
		        pst = con.prepareStatement(sql);
		        pst.setString(1, loggedInUserId); // 로그인된 사용자 ID
		        pst.setInt(2, review.getProduct_no()); // product_no
		        pst.setString(3, review.getItem_no()); // item_no
		        pst.setString(4, review.getContents());
		        pst.setString(5, review.getRating());

		        row = pst.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        close(pst, con);
		    }
		    return row;
		}

		

	   public ArrayList<Review> getOrderItemsByUserId(String userId) {
		   ArrayList<Review> orderItems = new ArrayList<>();
		   String sql = "SELECT oi.item_no, oi.product_no " +
		             "FROM order_itemtbl oi " +
		             "JOIN ordertbl o ON oi.order_no = o.order_no " +
		             "WHERE o.user_id = ?";
		   Connection con = null;
		   PreparedStatement pst = null;
		   ResultSet rs = null;

		    try {
		        con = dbcon(); // 데이터베이스 연결
		        pst = con.prepareStatement(sql);
		        pst.setString(1, userId);
		        rs = pst.executeQuery();

		        while (rs.next()) {
		        	Review item = new Review();
		            item.setItem_no(rs.getString("item_no"));
		            item.setProduct_no(rs.getInt("product_no")); 
		            orderItems.add(item);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        close(rs, pst, con); // ResultSet, PreparedStatement, Connection 모두 닫기
		    }
		    return orderItems;
		}

	   
	   //리뷰 삭제   
	   public int delete(String review_no) {
		   int row = 0;
		   Connection con = null;		    
		   PreparedStatement pst =null;
		   
		   try {
			   con = dbcon();
			// review_no를 숫자로 변환
			  // int reviewNoInt = Integer.parseInt(review_no);
			   
			   //1.리뷰 삭제
			   String sql = "delete from reviewtbl where review_no=?";
			   pst = con.prepareStatement(sql);
			   pst.setString(1, review_no); // int로 설정
			   row = pst.executeUpdate();
			   
			   //2.리뷰 번호 재조정
			   String updateSql = "UPDATE reviewtbl SET review_no = review_no - 1 WHERE review_no > ?";
			   // String updateSql = "UPDATE reviewtbl SET review_no = ROWNUM " +
			   //"WHERE review_no > (SELECT review_no FROM reviewtbl WHERE review_no = ?)";
			   pst= con.prepareStatement(updateSql);
			    pst.setString(1, review_no);
			    row = pst.executeUpdate();
		   		   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	        close(pst, con);  // 연결 종료는 finally 블록에서 수행
	    }
	    return row;
	}
	   
	   
	// 검색하기 (페이지네이션 적용)
	   public ArrayList<Review> searchReviews(String searchType, String searchQuery, int currentPage, int pageSize) {
	       ArrayList<Review> reviews = new ArrayList<>();
	       String query = "SELECT * FROM ( " +
	                      "  SELECT reviewtbl.*, ROWNUM AS rnum FROM reviewtbl " +
	                      "  WHERE " + searchType + " LIKE ? " +
	                      ") WHERE rnum BETWEEN ? AND ?";
	       
	       Connection con = null;
	       PreparedStatement pst = null;
	       ResultSet rs = null;

	       try {
	           con = dbcon();
	           pst = con.prepareStatement(query);
	           pst.setString(1, "%" + searchQuery + "%");
	           int start = (currentPage - 1) * pageSize + 1;
	           int end = currentPage * pageSize;
	           pst.setInt(2, start);
	           pst.setInt(3, end);
	           rs = pst.executeQuery();

	           while (rs.next()) {
	        	   int review_no = rs.getInt("review_no");
	               String user_id = rs.getString("user_id");
	               int product_no = rs.getInt("product_no");
	               String item_no = rs.getString("item_no");
	               String contents = rs.getString("contents");
	               String rating = rs.getString("rating");
	               String created_at = rs.getString("created_at");

	               // User 객체 생성 및 초기화
	               User user = new User();
	               user.setId(user_id); // 사용자 ID 설정
	               Review review = new Review(review_no, user, product_no, item_no, contents, rating, created_at);
	               reviews.add(review);
	           }
	       } catch (SQLException e) {
	           e.printStackTrace();
	       }

	       return reviews;
	   }	   
	   
	   //검색된 총 레코드 수를 반환
	   public int getSearchTotalCount(String searchType, String searchQuery) {
		    int count = 0;
		    String query = "SELECT COUNT(*) FROM reviewtbl WHERE " + searchType + " LIKE ?";
		    
		    Connection con = null;
		    PreparedStatement pst = null;
		    ResultSet rs = null;

		    try {
		        con = dbcon();
		        pst = con.prepareStatement(query);
		        pst.setString(1, "%" + searchQuery + "%");
		        rs = pst.executeQuery();
		        
		        if (rs.next()) {
		            count = rs.getInt(1);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        close(con, pst, rs);
		    }

		    return count;
		}   
	   
	   
	   
	   //자원해제
	   public void close( AutoCloseable ...a) {
			for( AutoCloseable  item : a) {
				if (item != null) {//item 객체가 null인지 확인하고, null인 경우에 대한 예외 처리를 추가하는 방법
			        try {
			            item.close(); // AutoCloseable 객체 닫기
			        } catch (Exception e) {
			            // 예외 처리 로깅 또는 추가 처리
			            e.printStackTrace();
			        }
			    } else {
			        // item이 null일 경우의 처리
			        System.out.println("Warning: item is null, cannot close.");
			    }
			}
	   }
	   
	   
	   public static void main(String[] args) {
		   ReviewDAO dao = new ReviewDAO();
			//ArrayList<Review> r = dao.selectAllReview();
			//for (Review review : r) {
			//	System.out.println(review);
			//}
			ArrayList<Review> list = dao.listPaging(1, 10);
			System.out.println(list);
		   
			//추가
//		   Review r = new Review("1","2","3","4","5");
//		   dao.addReview(r);
//		   System.out.println(r);
	}
}
