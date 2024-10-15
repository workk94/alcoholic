package web.model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import web.pages.ProductDTO;

public class ShopService {
	ShopDAO dao = new ShopDAO();
	
	public ArrayList<ProductDTO> getAllProduct() {
		return dao.selectAllProduct();
	}
	
	public ProductDTO getProduct(String productNo) {
		return dao.selectProduct(productNo);
	}
	
	public JSONArray getAllProductJsonArray() {
		ArrayList<ProductDTO> list = dao.selectAllProduct();
		JSONArray arr = new JSONArray();
		for(int i = 0; i < list.size(); i++) {
			ProductDTO product = list.get(i);
			JSONObject obj = new JSONObject();
			obj.put("productNo", product.getProductNo());
			obj.put("pname", product.getPname());
			obj.put("category", product.getCategory());
			obj.put("price", product.getPrice());
			obj.put("imgUrl", product.getImgUrl());
			arr.put(obj);
		}
		
		return arr;
	}
	
	public JSONArray getProductByCat(String category_) {
		ArrayList<ProductDTO> list = dao.selectProductByCat(category_);
		JSONArray arr = new JSONArray();
		for(int i = 0; i < list.size(); i++) {
			ProductDTO product = list.get(i);
			JSONObject obj = new JSONObject();
			obj.put("productNo", product.getProductNo());
			obj.put("pname", product.getPname());
			obj.put("category", product.getCategory());
			obj.put("price", product.getPrice());
			obj.put("imgUrl", product.getImgUrl());
			arr.put(obj);
		}
		return arr;
	}

	public ArrayList<ProductDTO> getProducts(int page, int pageSize) {
	    return dao.getListPage(page, pageSize);
	}

	public int getTotal() {
	    return dao.getTotal();
	}

	
}
