package web.userpage;

import java.sql.Date;

public class Order {

	String user_id;
	String name;
	String category;
	int price;
	String quantity;
	Date order_date;
	
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	public Order(String user_id, String name, String category, int price, String quantity, Date date) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.order_date = date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	@Override
	public String toString() {
		return "Order [user_id=" + user_id + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", quantity=" + quantity + ", order_date=" + order_date + "]";
	}
	
	
	
	
}
