package web.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalesDAO {
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

	// 일별 판매량
	public ArrayList<Sales> dailySales() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Sales> list = new ArrayList<>();

		con = dbcon();
		try {

			String sql = "SELECT TO_CHAR(o.order_date, 'YY/MM/DD') AS formatted_order_date, SUM(p.price * oi.quantity) AS total_price, SUM(oi.quantity) AS total_quantity FROM ordertbl o JOIN order_itemtbl oi ON o.order_no = oi.order_no JOIN producttbl p ON oi.product_no = p.product_no GROUP BY o.order_no, o.user_id, TO_CHAR(o.order_date, 'YY/MM/DD') ORDER BY TO_CHAR(o.order_date, 'YY/MM/DD'), o.order_no";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String orderDate = rs.getString(1);
				int price = rs.getInt(2);
				int quantity = rs.getInt(3);

				Sales sales = new Sales(null ,orderDate, null, null, price, quantity);

				list.add(sales);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbclose(con, pst, rs);
		}
		return list;
	}

	// 상품별 판매량
	public ArrayList<Sales> salesByItem() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Sales> list = new ArrayList<>();

		con = dbcon();
		try {

			String sql = "SELECT p.product_no, p.name AS product_name, p.category, SUM(p.price * oi.quantity) AS total_order_amount, SUM(oi.quantity) AS total_quantity FROM ordertbl o JOIN order_itemtbl oi ON o.order_no = oi.order_no JOIN producttbl p ON oi.product_no = p.product_no GROUP BY p.product_no, p.name, p.category ORDER BY total_order_amount DESC";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String productNo = rs.getString(1);
				String productName = rs.getString(2);
				int price = rs.getInt(4);
				int quantity = rs.getInt(5);

//				

				Sales sales = new Sales(productNo, null,  productName, null, price, quantity);

				list.add(sales);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbclose(con, pst, rs);
		}
		return list;
	}
	//카테고리별 판매현황
	public ArrayList<Sales> salesByCategory() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Sales> list = new ArrayList<>();

		con = dbcon();
		try {

			String sql = "SELECT p.category, SUM(p.price * oi.quantity) AS total_order_amount, SUM(oi.quantity) AS total_quantity FROM ordertbl o JOIN order_itemtbl oi ON o.order_no = oi.order_no JOIN producttbl p ON oi.product_no = p.product_no GROUP BY p.category ORDER BY total_order_amount DESC";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String category = rs.getString(1);
				int price = rs.getInt(2);
				int quantity = rs.getInt(3);


				Sales sales = new Sales(null, null, null, category, price, quantity);

				list.add(sales);
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
		SalesDAO dao = new SalesDAO();
		ArrayList<Sales> list = dao.salesByCategory();
		System.out.println(list);

	}
}
