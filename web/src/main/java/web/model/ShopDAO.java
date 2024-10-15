package web.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import web.pages.ProductDTO;
import web.userpage.ProductDAO;

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

	public ArrayList<ProductDTO> getListPage(int page, int pageSize) {

		int start = (page - 1) * pageSize + 1;
		int end = page * pageSize;

		String sql = "SELECT * FROM ( " + "SELECT ROWNUM rnum, product_no, name, category, price, img_url "
				+ "FROM PRODUCTTBL " + "WHERE ROWNUM <= ? " + ") WHERE rnum >= ?";

		ArrayList<ProductDTO> list = new ArrayList<>();
		try (Connection con = dbCon(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, end);
			pst.setInt(2, start);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					ProductDTO p = new ProductDTO(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
							rs.getString(6));
					list.add(p);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public int getTotal() {
		String sql = " select count(*) from PRODUCTTBL ";

		int count = 0;
		try (Connection con = dbCon();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
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

	public ArrayList<ProductDTO> selectProductByCat(String category_) {

		ArrayList<ProductDTO> list = new ArrayList<>();

		String sql = "SELECT * FROM PRODUCTTBL WHERE CATEGORY = ?";

		try (Connection con = dbCon(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, category_);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					String productNo = rs.getString("product_no");
					String name = rs.getString("name");
					String category = rs.getString("category");
					int price = rs.getInt("price");
					String imgUrl = rs.getString("img_url");

					ProductDTO product = new ProductDTO(productNo, name, category, price, imgUrl);
					list.add(product);
				}
			} catch (SQLException e) {
				e.printStackTrace();
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
				if (rs.next()) {
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

	public ArrayList<ProductDTO> selectProductByName(String name) {

		String sql = "SELECT * FROM PRODUCTTBL WHERE name LIKE ?";
		ArrayList<ProductDTO> list = new ArrayList<>();

		try (Connection con = dbCon(); PreparedStatement pst = con.prepareStatement(sql);) {
			 pst.setString(1, "%" + name + "%");

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					ProductDTO product = new ProductDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),
							rs.getString(5));
					
					list.add(product);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	public static void main(String[] args) {
		ShopDAO dao = new ShopDAO();
		ArrayList<ProductDTO> list = dao.selectProductByCat("wine");
		System.out.println(list.toString());
		for(ProductDTO p : list) {
			System.out.println(p);
		}
	}
}
