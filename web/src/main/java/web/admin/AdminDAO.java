package web.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class AdminDAO {
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
	
	// 고객 정보 전체 조회 (이름,아이디,비밀번호,전화번호)
	public ArrayList<Admin> selectAll() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Admin> list = new ArrayList<>();

		con = dbcon();
		try {

			String sql = "select id,password,name,ssn,phone,address from usertbl";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String ssn = rs.getString(4);
				String phone = rs.getString(5);
				String address = rs.getString(6);

				Admin user = new Admin(id, pw, name, ssn,phone,address);

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
	//고객 한명 정보 조회
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
	//고객 정보 수정(비밀번호,전화번호,주소)
	public int update(Admin admin) {
		int rRow = 0;
		Connection con = dbcon();
		PreparedStatement pst = null;
		
		String sql = "update usertbl set password = ?, phone = ?, address = ? where id = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, admin.getPw());
			pst.setString(2, admin.getPhone());
			pst.setString(3, admin.getAddress());
			pst.setString(4, admin.getId());
			rRow = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbclose(con, pst);
		}
		
		return rRow;
	}
		
	//고객 삭제
	int delete(String id) throws SQLIntegrityConstraintViolationException {
		int rRow = 0;
		Connection con = dbcon();
		PreparedStatement pst = null;
		String sql = "delete from usertbl where id = ? ";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rRow = pst.executeUpdate();
		}catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbclose(con, pst);
		}
		
		
		return rRow;
	}
	
	// 페이징 리스트 구하기
		public ArrayList<Admin> selectListPaging(int currentPage, int pageSize) {
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			int start = 1;
			int end = 5;

			start = (currentPage - 1) * pageSize + 1;
			end = currentPage * pageSize; // 1 => 1~10 2 => 11~20

			String sql = " select * " + " from " + " (select rownum num,id,password,name,ssn,phone,address from usertbl) "
					+ " where num between ? and ? "; // 페이징쿼리
			ArrayList<Admin> list = new ArrayList<>();

			con = dbcon();
			try {
				pst = con.prepareStatement(sql);
				
				pst.setInt(1, start);
				pst.setInt(2, end);
				
				rs = pst.executeQuery();

				while (rs.next()) {
					String id = rs.getString(2);
					String pw = rs.getString(3);
					String name = rs.getString(4);
					String ssn = rs.getString(5);
					String phone = rs.getString(6);
					String address = rs.getString(7);

					Admin user = new Admin(id, pw, name, ssn,phone,address);

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
		public int selectTotalCnt() {
			
			Connection con = dbcon();

			String sql = "select count(*) from usertbl"; // 전체레코드 수
			int rowTotalCnt = 0;

			try {
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();

				if (rs.next()) {
					rowTotalCnt = rs.getInt(1);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rowTotalCnt;
		}
	
	public static void main(String[] args) {
		AdminDAO dao = new AdminDAO();
		ArrayList<Admin> s = dao.selectAll();
		System.out.println(s);
		
		Admin admin = new Admin("paulbaek", "paul133", null, null, "010-9353-1903", "서울시 마포구");
		int i = dao.update(admin);
		System.out.println(i);
		ArrayList<Admin> s2 = dao.selectAll();
		System.out.println(s2);
	}
}
