package web.admin;

public class Product {
	String no ;
	String name;
	String category;
	int price;
	String imgUrl;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(String no, String name, String category, int price, String imgUrl) {
		super();
		this.no = no;
		this.name = name;
		this.category = category;
		this.price = price;
		this.imgUrl = imgUrl;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
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
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	@Override
	public String toString() {
		return "Product [no=" + no + ", name=" + name + ", category=" + category + ", price=" + price + ", imgUrl="
				+ imgUrl + "]";
	}
	
	
}
