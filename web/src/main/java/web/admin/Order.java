package web.admin;

public class Order {
	String orderNo;
	String userId;
	String orderDate;
	String itemNo;
	String productNo;
	String productName;
	String category;
	int price;
	int quantity;
	String imgUrl;
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getItemNo() {
		return itemNo;
	}
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
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
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	
	
	
	 public Order() {
		// TODO Auto-generated constructor stub
	}
	public Order(String orderNo, String userId, String orderDate, String itemNo, String productNo, String productName,
			String category, int price, int quantity, String imgUrl) {
		super();
		this.orderNo = orderNo;
		this.userId = userId;
		this.orderDate = orderDate;
		this.itemNo = itemNo;
		this.productNo = productNo;
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.imgUrl = imgUrl;
	}
	
}
	

	
	
	
	