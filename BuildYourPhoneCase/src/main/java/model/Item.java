package model;

import java.util.Objects;

public class Item {
	int id;
	String name;
	int availableQuantity;
	double price;
	String picURL;
	int pageNum ; 
	
	
    public Item() {}
	
	public Item(int id, String name, int availQuan, double price, String picURL, int pageNum) {
		this.id = id;
		this.name = name;
		this.availableQuantity = availQuan;
		this.price = price;
		this.picURL = picURL;
		this.pageNum = pageNum ; 
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getPicURL() {
		return picURL;
	}

	public void setPicURL(String picURL) {
		this.picURL = picURL;
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
		return "Item [id=" + id + ", name=" + name + ", availableQuantity=" + availableQuantity + ", price=" + price
				+ ", picURL=" + picURL + ", pageNum=" + pageNum + "]";
	}

	 

	
	
}
