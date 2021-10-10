package model;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Objects;

public class Item {
	int id ; 
	String name; 
	double price; 
	int quantity;
	String image;
	private Dictionary<Integer, String> idImageDic = new Hashtable<Integer, String>();
	private Dictionary<Integer, String> idNameDic = new Hashtable<Integer, String>();
	private Dictionary<Integer, Double> idPriceDic = new Hashtable<Integer, Double>();
	public Item() {
		loadData() ; 
	}
	
	public Item(int id) {
		this.id =id; 
		/*loadData();
		this.name = idNameDic.get(id) ; 
		this.price = idPriceDic.get(id) ; 
		this.image = idImageDic.get(id) ;*/ 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		//FIXME: CAN WE DO THIS  !!!!!!!
		/*this.name = idNameDic.get(id) ; 
		this.price = idPriceDic.get(id) ; 
		this.image = idImageDic.get(id) ;   */
		
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public String getImage() {
		return image;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", image=" + image
				+ "]";
	}

	private void loadData() {
		//FIXME : images load from local cache
				idImageDic.put(0, "https://cdn.webshopapp.com/shops/221036/files/297679314/fooncase-iphone-11-pro-phone-case-tropical-desire.jpg");
				idImageDic.put(1, "https://m.media-amazon.com/images/I/418I24uGLlL.jpg");
				idImageDic.put(2, "https://cdn.shopify.com/s/files/1/1706/8353/products/here-comes-the-sun-colorblock-sunset-case-iphone-case-bold-iphone-12-pro-714397_800x.progressive.jpg?v=1631572203");
				idImageDic.put(3, "https://static.gibson.com/product-images/Gibson/APHL/APHL-IPXXS.png");
				idImageDic.put(4, "https://cdn-image02.casetify.com/usr/16571/16546571/~v30/13084976_iphone-x__color_silver_16000304.png.350x350-w.m80.jpg");
				idImageDic.put(5, "https://cdn.trendhunterstatic.com/thumbs/make-my-case.jpeg");
				
				//FIXME: get from db
				idNameDic.put(0, "iphone9Case") ; 
				idNameDic.put(1, "iphone10Case") ; 
				idNameDic.put(2, "iphone11Case") ; 
				idNameDic.put(3, "iphone12Case") ; 
				idNameDic.put(4, "iphone13Case") ; 
				idNameDic.put(5, "iphoneXCase") ; 
				
				idPriceDic.put(0, 20.0) ; 
				idPriceDic.put(1, 25.0) ; 
				idPriceDic.put(2, 30.0) ; 
				idPriceDic.put(3, 30.0) ; 
				idPriceDic.put(4, 30.0) ; 
				idPriceDic.put(5, 30.0) ; 
	}
}
