package web.admin;

import java.util.ArrayList;

public class ProductService {
	ProductDAO dao = new ProductDAO();
	
	public ArrayList<Product> getProductList(){
		return dao.selectAll();
	}
	
	public Product getProductDetail(String no) {
		return dao.selectOne(no);
	}
	public int updateProduct(Product product) {
		return dao.update(product);
	}
	public int deleteProduct(String no) {
		return dao.delete(no);
	}
	public int addProduct(Product product) {
		return dao.insert(product);
	}
	
}
