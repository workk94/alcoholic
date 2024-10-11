package web.pages;

public class ProductDTO {
	String productNo;
	String pname;
	String category;
	int price;
	String imgUrl;
	
	//카트수량
	int qty = 0;
	
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductDTO(String productNo, String pname, String category, int price, String imgUrl) {
		super();
		this.productNo = productNo;
		this.pname = pname;
		this.category = category;
		this.price = price;
		this.imgUrl = imgUrl;
	}
	
	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
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

	
	// 카트 수량
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "ProductDTO [productNo=" + productNo + ", pname=" + pname + ", category=" + category + ", price=" + price
				+ ", imgUrl=" + imgUrl + ", qty=" + qty + "]";
	}
	
}
