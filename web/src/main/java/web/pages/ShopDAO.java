package web.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShopDAO {
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
				System.out.println("db connected");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

	public ArrayList<ProductDTO> selectAllProduct() {

		ArrayList<ProductDTO> list = new ArrayList<>();

		String sql = "SELECT * FROM PRODUCTTBL";

		try (Connection con = dbCon();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
				String productNo = rs.getString(1);
				String name = rs.getString(2);
				String category = rs.getString(3);
				int price = rs.getInt(4);
				String imgUrl = rs.getString(5);

				ProductDTO product = new ProductDTO(productNo, name, category, price, imgUrl);
				list.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public ProductDTO selectProduct(String productNo) {
		ProductDTO product = new ProductDTO();
		String sql = "SELECT * FROM PRODUCTTBL WHERE PRODUCT_NO = ?";

		try (Connection con = dbCon(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, productNo);

			try (ResultSet rs = pst.executeQuery()) {
				if(rs.next()) {
					String product_no = rs.getString(1);
					String pname = rs.getString(2);
					String category = rs.getString(3);
					int price = rs.getInt(4);
					String img_url = rs.getString(5);
					
					product.setProductNo(product_no);
					product.setPname(pname);
					product.setCategory(category);
					product.setPrice(price);
					product.setImgUrl(img_url);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return product;
	}

	// test

	public static void main(String[] args) {
		ShopDAO dao = new ShopDAO();
		ProductDTO p = dao.selectProduct("");
		System.out.println(p);
		
	}
}
