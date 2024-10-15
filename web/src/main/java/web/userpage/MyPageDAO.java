package web.userpage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import web.model.User;

public class MyPageDAO {
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:testdb";
    String user ="scott";
    String password = "tiger";

    public Connection dbcon() {
        Connection con = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            if (con != null);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void update(User user) {
        Connection con = null;
        PreparedStatement pst = null;

        String sql = "UPDATE usertbl SET password=?, phone=?, address=? WHERE id=?";
        try {
            con = dbcon();
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getPw());
            pst.setString(2, user.getPhone());
            pst.setString(3, user.getAddr());
            pst.setString(4, user.getId());
            pst.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        close(pst, con);
    }

    public void insertMember(User user) {
    	Connection con = dbcon();
    	PreparedStatement pst = null;
    	
    	String sql = "insert into dd(pw, phone, addr) values(?, ?, ?)";
    	
    	try{
    		con = dbcon();
    		pst = con.prepareStatement(sql);
    		
    		pst.setString(1, user.getPw());
    		pst.setString(2, user.getPhone());
    		pst.setString(3, user.getAddr());
    		
    		pst.executeUpdate();
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	close(pst, con);
    }
    
    public void close(AutoCloseable... a) {
        for (AutoCloseable item : a) {
            try {
                item.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
