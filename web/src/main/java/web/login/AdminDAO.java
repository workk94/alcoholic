package web.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
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
	
	public AdminDTO findByIdAndPassword(String id, String pw) {
		AdminDTO admin = null;
	    String sql = "SELECT * FROM USERTBL WHERE id = ? AND password = ?";
	    
	    try (Connection con = dbCon();
	         PreparedStatement pst = con.prepareStatement(sql)) {
	         
	        pst.setString(1, id);
	        pst.setString(2, pw);
	        
	        try (ResultSet rs = pst.executeQuery()) {
	            if (rs.next()) {
	            	admin = new AdminDTO();
	                admin.setId(rs.getString("id"));
	                admin.setName(rs.getString("password"));
	                admin.setPw(rs.getString("name"));
	            }
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return admin;
	}
}
