package web.admin;

public class Sales {

	String productNo;
	String orderDate;
	String productName;
	String category;
	int price;
	int quantity;

	public Sales() {
		// TODO Auto-generated constructor stub
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Sales(String productNo, String orderDate, String productName, String category, int price, int quantity) {
		super();
		this.productNo = productNo;
		this.orderDate = orderDate;
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Sales [productNo=" + productNo + ", orderDate=" + orderDate + ", productName=" + productName
				+ ", category=" + category + ", price=" + price + ", quantity=" + quantity + "]";
	}

}
