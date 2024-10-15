package web.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;


public class ProductDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user = "scott";
	String password = "tiger";


	private Connection dbcon() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

	// AutoCloseable => 인터페이스 상속
	// Connection, PreparedStatement, ResultSet
	private void dbclose(AutoCloseable... ac) {
		for (AutoCloseable a : ac) {
			if (a != null) {
				try {
					a.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	
	// 상품 정보 전체 조회 (이름,아이디,비밀번호,전화번호)
	public ArrayList<Product> selectAll() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Product> list = new ArrayList<>();

		con = dbcon();
		try {

			String sql = "select * from producttbl";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String no = rs.getString(1);
				String name = rs.getString(2);
				String category = rs.getString(3);
				int price = rs.getInt(4);
				String imgUrl = rs.getString(5);
				

				Product product = new Product(no, name, category, price, imgUrl);

				list.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbclose(con, pst, rs);
		}
		return list;
	}
	//상품 정보 조회
	public Product selectOne(String no) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs =null;
		String sql = "select * from producttbl where product_no = ?";
		
		Product product = null;
		try {
			pst = con.prepareStatement(sql);
			// ?에 들어갈 값 채우기
			pst.setString(1, no);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				String tno = rs.getString(1);
				String name = rs.getString(2);
				String category = rs.getString(3);
				int price = rs.getInt(4);
				String imgUrl = rs.getString(5);
				

				product = new Product(tno, name, category, price, imgUrl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbclose(con, pst, rs);
		}
		return product;
	}
	//상품 정보 수정(비밀번호,전화번호,주소)
	public int update(Product product) {
		int rRow = 0;
		Connection con = dbcon();
		PreparedStatement pst = null;
		
		String sql = "update producttbl set name = ?, price = ?, img_url = ? where product_no = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, product.getName());
			pst.setInt(2, product.getPrice());
			pst.setString(3, product.getImgUrl());
			pst.setString(4, product.getNo());
			rRow = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbclose(con, pst);
		}
		
		return rRow;
	}
		
	//상품 삭제
	int delete(String no) throws SQLIntegrityConstraintViolationException {
		int rRow = 0;
		Connection con = dbcon();
		PreparedStatement pst = null;
		String sql = "delete from producttbl where product_no = ? ";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, no);
			rRow = pst.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			throw e;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbclose(con, pst);
		}
		
		
		return rRow;
	}
	//상품 추가
	public int insert(Product product) {
		int rRow = 0;
		Connection con = dbcon();
		PreparedStatement pst = null;
		String sql = "insert into producttbl values(no_seq.NEXTVAL,?,?,?,?)";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, product.getName());
			pst.setString(2, product.getCategory());
			pst.setInt(3, product.getPrice());
			pst.setString(4, product.getImgUrl());
			rRow = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbclose(con, pst);
		}
		
		return rRow;
	}
	
	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		ArrayList<Product> p = dao.selectAll();
		System.out.println(p);
		
	}
}
