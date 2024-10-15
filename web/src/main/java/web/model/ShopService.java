package web.model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import web.pages.ProductDTO;
import web.userpage.Product;

public class ShopService {
	ShopDAO dao = new ShopDAO();
	
	public ArrayList<ProductDTO> getAllProduct() {
		return dao.selectAllProduct();
	}
	
	public ProductDTO getProduct(String productNo) {
		return dao.selectProduct(productNo);
	}
	
	public ArrayList<ProductDTO> getProductByCat(String category) {
		return dao.selectProductByCat(category);
	}

	public ArrayList<ProductDTO> getProducts(int page, int pageSize) {
	    return dao.getListPage(page, pageSize);
	}

	public int getTotal() {
	    return dao.getTotal();
	}
	
	public ArrayList<ProductDTO> searchProductList(String name){
		return dao.selectProductByName(name);
	}
}
