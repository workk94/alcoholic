package web.userpage;

public class Product {

	String prod_no;
	String name;
	int price;
	
	public Product(String prod_no, String name, int price) {
		super();
		this.prod_no = prod_no;
		this.name = name;
		this.price = price;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public String getProd_no() {
		return prod_no;
	}
	public void setProd_no(String prod_no) {
		this.prod_no = prod_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [prod_no=" + prod_no + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
}
