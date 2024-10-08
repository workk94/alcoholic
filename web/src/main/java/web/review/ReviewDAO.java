package web.review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	   //리뷰전체조회
	   public ArrayList<Review> selectAllReview() {
		    ArrayList<Review> list = new ArrayList<>();
		    String sql = "SELECT * FROM reviewtbl";
		    Connection con = null;
		    PreparedStatement pst = null;
		    ResultSet rs = null;

		    try {
		        con = dbcon();
		        pst = con.prepareStatement(sql);
		        rs = pst.executeQuery();

		        while (rs.next()) {
		            String review_no = rs.getString("review_no");
		            String user_id = rs.getString("user_id");
		            String product_no = rs.getString("product_no");
		            String item_no = rs.getString("item_no");
		            String contents = rs.getString("contents");
		            String rating = rs.getString("rating");
		            String created_at = rs.getString("created_at");

		            Review review = new Review(review_no, product_no, item_no, contents, rating, user_id, created_at);
		            list.add(review);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (rs != null) rs.close();
		            if (pst != null) pst.close();
		            if (con != null) con.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		    return list;
		}

	   
	   
	 //리뷰 상세 조회
	   public Review selectOne(String review_no) {
		
		   Review review = new Review();
		   
		   try {
			Connection con = dbcon();
			PreparedStatement pst = null;
			ResultSet rs = null;
			
			String sql = "select * from review_tbl where review_no";
			pst =con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				String review_no1 = rs.getString(1);
				String product_no = rs.getString(2);
				String item_no = rs.getString(3);
				String contents = rs.getString(4);
				String rating = rs.getString(5);
				String user_id = rs.getString(6);
				String created_at = rs.getString(7);
				
				review = new Review(review_no1, product_no, item_no, contents, rating, user_id, created_at);
			}
			   close(rs,pst,con);
			   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return review;
	   }
	   
	   
	   
	// 상세조회 한 뒤 수정 가능 => 수정하면 update 
	   public void update (String contents,String review_no, String rating ){
		   
		   try {
			Connection con = dbcon();
			
			String sql ="update  review_tbl set  contents =?, rating=?  where review_no= ? ";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, contents);
			pst.setString(2, rating);
			pst.setString(3, review_no);
			pst.executeUpdate();
			
			close( pst, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   
		//리뷰 삭제   
	   public void delete(String review_no) {
		   try {
			Connection con = dbcon();
		   String sql = "delete review_tbl where review_no";
		   
		   PreparedStatement pst = con.prepareStatement(sql);
		   pst.setString(1, review_no);
		   pst.executeUpdate();
		   		   
		   close( pst, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	   }
	   
	   //자원해제
	   public void close( AutoCloseable ...a) {
			for( AutoCloseable  item : a) {
			   try {
				item.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	   
	   
	   public static void main(String[] args) {
		   ReviewDAO dao = new ReviewDAO();
			ArrayList<Review> r = dao.selectAllReview();
			for (Review review : r) {
				System.out.println(review);
			}
	}

}
