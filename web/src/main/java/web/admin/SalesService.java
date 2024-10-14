package web.admin;

import java.util.ArrayList;

public class SalesService {
	SalesDAO dao = new SalesDAO();
	
	public ArrayList<Sales> getDailySales(){
		return dao.dailySales();
	}
	
	public ArrayList<Sales> getSalesByItem(){
		return dao.salesByItem();
	}
	
	public ArrayList<Sales> getSalesByCategory(){
		return dao.salesByCategory();
	}
}
