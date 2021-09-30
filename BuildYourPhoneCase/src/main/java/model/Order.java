package model;

import java.util.ArrayList;

public class Order {
	
	ArrayList<Item> items = new ArrayList<Item>();
	

	public Order() {
		
	}
	 
	 

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		
		return "Order [items=" + items + "]";
	}
	
	

}
