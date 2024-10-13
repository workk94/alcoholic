package web.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAO {
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
	//주문내역 출력 (주문번호 , 주문날짜, 아이디 , 총주문금액, 총주문수량)
	public ArrayList<Order> selectAll() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Order> list = new ArrayList<>();

		con = dbcon();
		try {

			String sql = "SELECT o.order_no, o.order_date, o.user_id,  SUM(p.price * oi.quantity) AS total_price, SUM(oi.quantity) AS total_quantity FROM ordertbl o JOIN order_itemtbl oi ON o.order_no = oi.order_no JOIN producttbl p ON oi.product_no = p.product_no GROUP BY o.order_no, o.user_id, o.order_date ORDER BY o.order_date, o.order_no";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String orderNo = rs.getString(1);
				String orderDate = rs.getString(2);
				String userId = rs.getString(3);
				int price = rs.getInt(4);
				int quantity = rs.getInt(5);
				

				Order order = new Order(orderNo, userId, orderDate, null, null, null, null, price, quantity,null);

				list.add(order);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbclose(con, pst, rs);
		}
		return list;
	}
	
	//상세 내역 출력 
		public ArrayList<Order> selectOne(String no) {
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			ArrayList<Order> list = new ArrayList<>();

			con = dbcon();
			try {

				String sql = "SELECT o.order_no, o.user_id, o.order_date, oi.item_no, oi.product_no, p.name AS product_name, p.category, p.price, oi.quantity,p.img_url FROM ordertbl o JOIN order_itemtbl oi ON o.order_no = oi.order_no JOIN producttbl p ON oi.product_no = p.product_no WHERE o.ORDER_NO = ? ORDER BY o.order_date, oi.item_no";

				pst = con.prepareStatement(sql);
				// ?에 들어갈 값 채우기
				pst.setString(1, no);
				rs = pst.executeQuery();

				while (rs.next()) {
					String orderNo = rs.getString(1);
					String orderDate = rs.getString(3);
					String userId = rs.getString(2);
					String itemNo = rs.getString(4);
					String productNo = rs.getString(5);
					String productName = rs.getString(6);
					String category = rs.getString(7);
					int price = rs.getInt(8);
					int quantity = rs.getInt(9);
					String imgUrl = rs.getString(10);
					

			Order order = new Order(orderNo, userId, orderDate, itemNo, productNo, productName,
							category, price, quantity,imgUrl);

					list.add(order);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				dbclose(con, pst, rs);
			}
			return list;
		}
	
	public static void main(String[] args) {
		OrderDAO dao = new OrderDAO();
		ArrayList<Order> order = dao.selectOne("ORD001");
		System.out.println(order);
				
	}
}
