package web.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:ORCLCDB";
	String user = "scott";
	String password = "tiger";

	// dbcon()
	// close()
	// selectAll() : 전체조회
	// insert() : 등록
	// update() : 수정
	// delete() : 석제
	// selectOne() : 한개 조회

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
	
	// 고객 정보 전체 조회 (이름,아이디,비밀번호,전화번호)
	public ArrayList<Admin> selectAll() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Admin> list = new ArrayList<>();

		con = dbcon();
		try {

			String sql = "select id,password,name,phone from usertbl";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String phone = rs.getString(4);

				Admin user = new Admin(id, pw, name, phone);

				list.add(user);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbclose(con, pst, rs);
		}
		return list;
	}
	public Admin selectOne(String id) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs =null;
		String sql = "select * from usertbl where id = ?";
		
		Admin admin = null;
		try {
			pst = con.prepareStatement(sql);
			// ?에 들어갈 값 채우기
			pst.setString(1, id);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				String tid = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String ssn = rs.getString(4);
				String phone = rs.getString(5);
				String address = rs.getString(6);
				
				admin = new Admin(tid,pw,name,ssn,phone,address);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbclose(con, pst, rs);
		}
		return admin;
	}
	
	
	public static void main(String[] args) {
		AdminDAO dao = new AdminDAO();
		ArrayList<Admin> s = dao.selectAll();
		System.out.println(s);
		
		Admin admin = dao.selectOne("paulbaek");
		System.out.println(admin);
	}
}
