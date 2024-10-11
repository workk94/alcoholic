package web.userpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public void update(String id, String pw, String ssn, String phone, String addr) {
        Connection con = null;
        PreparedStatement pst = null;

        String sql = "UPDATE usertbl SET password=?, ssn=?, phone=?, address=? WHERE id=?";
        try {
            con = dbcon();
            pst = con.prepareStatement(sql);
            pst.setString(1, pw);
            pst.setString(2, ssn);
            pst.setString(3, phone);
            pst.setString(4, addr);
            pst.setString(5, id);

            pst.executeUpdate();
        } catch(SQLException e) {
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
