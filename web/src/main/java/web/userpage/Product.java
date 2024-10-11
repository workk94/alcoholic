package web.userpage;

public class Product {

	String prod_no;
	String name;
	String category;
	int quantity;
	int price;
	String img_url;


	public Product(String prod_no, String name, String category, int quantity, int price, String img_url) {
		super();
		this.prod_no = prod_no;
		this.name = name;
		this.category = category;
		this.quantity = quantity;
		this.price = price;
		this.img_url = img_url;
	}


	public Product() {
		// TODO Auto-generated constructor stub
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
		return "Product [prod_no=" + prod_no + ", name=" + name + ", category=" + category + ", quantity=" + quantity
				+ ", price=" + price + ", img_url=" + img_url + "]";
	}



	

}
