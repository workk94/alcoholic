package web.login;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user = "scott";
	String password = "tiger";

	private Connection dbCon() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			if (con != null)
				System.out.println("db connection success");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public ArrayList<User> selectAll() {
		ArrayList<User> list = new ArrayList<>();
		String sql = "SELECT * FROM USERTBL";

		try (Connection con = dbCon();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String ssn = rs.getString(4);
				String phone = rs.getString(5);
				String addr = rs.getString(6);
				list.add(new User(id, pw, name, ssn, phone, addr));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public User findByIdAndPassword(String id, String pw) {
	    User user = null;
	    String sql = "SELECT * FROM USERTBL WHERE id = ? AND password = ?";
	    
	    try (Connection con = dbCon();
	         PreparedStatement pst = con.prepareStatement(sql)) {
	         
	        pst.setString(1, id);
	        pst.setString(2, pw);
	        
	        try (ResultSet rs = pst.executeQuery()) {
	            if (rs.next()) {
	                user = new User();
	                user.setId(rs.getString("id"));
	                user.setName(rs.getString("password"));
	                user.setPw(rs.getString("name"));
	                user.setSsn(rs.getString("ssn"));
	                user.setPhone(rs.getString("phone"));
	                user.setAddr(rs.getString("address"));
	            }
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return user;
	}

}
