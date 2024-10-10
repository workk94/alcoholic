package web.pages;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

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
		}
		
		return arr;
	}
}
