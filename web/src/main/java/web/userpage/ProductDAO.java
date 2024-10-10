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
		String sql = "select * from producttbl";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String prod_no = rs.getString(1);
				String name = rs.getString(2);
				String category = rs.getString(3);
				int price = rs.getInt(4);
				String img = rs.getString(5);
				
				Product product = new Product(prod_no, name, category, price, img);
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
		String sql = "select * from producttbl where product_no=?";
		
		Product product = null;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, prod_no);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				String p_no = rs.getString(1);
				String name = rs.getString(2);
				String category = rs.getString(3);
				int price = rs.getInt(4);
				String img = rs.getString(5);
				
				product = new Product(prod_no, name, category, price, img);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return product;
		
	}
	
	
	public static void main(String[] args) {
//		ProductDAO  dao = new ProductDAO();
//		Product o = dao.selectOne("p001");
//		ArrayList<Product> i = dao.prodList();
//		
//		System.out.println( o);
//		System.out.println(i.toString());
//		
//		System.out.println("Size of product list: " + i.size());
	}
	
}
