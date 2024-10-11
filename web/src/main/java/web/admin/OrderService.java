package web.admin;

import java.util.ArrayList;

public class OrderService {

	OrderDAO dao = new OrderDAO();
	
	public ArrayList<Order> getOrderList(){
		return dao.selectAll();
	}
}
