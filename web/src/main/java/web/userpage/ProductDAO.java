package web.userpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {

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
	
	public ArrayList<Product> prodList(){
		
		ArrayList<Product> list = new ArrayList();
		
		Connection con = dbcon();
		String sql = "select o.product_no, p.name, p.category, o.quantity, p.price, p.img_url from producttbl p\r\n"
				+ "join order_itemtbl o\r\n"
				+ "on p.product_no = o.product_no";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String prod_no = rs.getString(1);
				String name = rs.getString(2);
				String category = rs.getString(3);
				int quantity = rs.getInt(4);
				int price = rs.getInt(5);
				String img = rs.getString(6);
				
				Product product = new Product(prod_no, name, category, quantity, price, img);
				list.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql");
		}
		
		return list;
		
	}
	
	public Product selectOne(String prod_no) {
		
		Connection con = dbcon();
		String sql = "select o.product_no, p.name, p.category, o.quantity, p.price, p.img_url from producttbl p\r\n"
				+ "join order_itemtbl o\r\n"
				+ "on p.product_no = o.product_no where o.product_no=?";
		
		Product product = null;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, prod_no);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				String p_no = rs.getString(1);
				String name = rs.getString(2);
				String category = rs.getString(3);
				int quantity = rs.getInt(4);
				int price = rs.getInt(5);
				String img = rs.getString(6);
				
				product = new Product(prod_no, name, category, quantity, price, img);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return product;
		
	}
	
	public int UpdateOrderItem(String prod_no, int quantity) {
		
		Connection con = dbcon();
		String sql = "update order_itemtbl set quantity=? where product_no=?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, quantity);
			pst.setString(2, prod_no);
			
			int result = pst.executeUpdate( );   //매개변수 없어야 함 !!! 
			if(result>0) {
				return result;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	
	public static void main(String[] args) {
		ProductDAO  dao = new ProductDAO();
		Product o = dao.selectOne("p001");
		Product o2 = dao.selectOne("p002");
		ArrayList<Product> i = dao.prodList();
		
	
		
		System.out.println( o);
		System.out.println( o2);
		System.out.println(i.toString());
		
		System.out.println("Size of product list: " + i.size());
		
		
	//	int rtn  =dao.UpdateOrderItem("p001", 3);
		//System.out.println( rtn);
		
	}

	
}
