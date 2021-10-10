package model;

import java.util.*;

public class Order {
	List<Item> items;

	public Order() {
		items = new ArrayList<Item>();
	}
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [items=" + items + "]";
	}
}
