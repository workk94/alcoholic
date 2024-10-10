package web.userpage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAO {

	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
	String password="tiger";
	
	
	public Connection dbcon() {		
		Connection con=null;
		try {
			Class.forName(driver);
			con  =DriverManager.getConnection(url, user, password);
			if( con != null) System.out.println("db ok");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;		
	}		
	
	public ArrayList<Order> getOrderList(){
		
		ArrayList<Order> list = new ArrayList();
		
		
		Connection con = dbcon();
		String sql = "select ordertbl.user_id, producttbl.name, producttbl.category, producttbl.price, order_itemtbl.quantity, ordertbl.order_date from order_itemtbl\r\n"
				+ "join ordertbl\r\n"
				+ "on ordertbl.order_no = order_itemtbl.order_no\r\n"
				+ "join producttbl\r\n"
				+ "on producttbl.product_no = order_itemtbl.product_no";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String user_id = rs.getString(1);
				String name = rs.getString(2);
				String category = rs.getString(3);
				int price = rs.getInt(4);
				String quantity = rs.getString(5);
				Date date = rs.getDate(6);
				
				Order order = new Order(user_id, name, category, price, quantity, date);
				list.add(order);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public static void main(String[] args) {
		ArrayList<Order> list = new ArrayList();
		OrderDAO dao = new OrderDAO();
		list = dao.getOrderList();
		
		System.out.println(list);
		
	}
	
}
