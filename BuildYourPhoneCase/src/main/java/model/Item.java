package model;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Objects;

public class Item {
	String name; 
	String price; 
	int quantity;
	String image ; 
	 
	
	public Item() {
		
	}
	
	

	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}
	
	public String getImagePathByName(String name) {
		//FIXME
		//get image path from db
		Dictionary<String, String> nameImageDic = new Hashtable<String, String>();
		 nameImageDic.put("iphone9Case", "https://cdn.webshopapp.com/shops/221036/files/297679314/fooncase-iphone-11-pro-phone-case-tropical-desire.jpg");
		 nameImageDic.put("iphone10Case",  "https://m.media-amazon.com/images/I/61zUnyvNEML._AC_SX522_.jpg");
		 nameImageDic.put("iphone11Case",   "https://cdn.shopify.com/s/files/1/1706/8353/products/here-comes-the-sun-colorblock-sunset-case-iphone-case-bold-iphone-12-pro-714397_800x.progressive.jpg?v=1631572203");
	        
		return  nameImageDic.get(name) ; 
		
		
	}


	public Item(String name, String price, int quantity, String image) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image = image; 
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	 

	@Override
	public int hashCode() {
		return Objects.hash(name, price);
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
		return Objects.equals(name, other.name) && Objects.equals(price, other.price);
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	} 
	

}
