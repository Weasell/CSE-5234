package model;

import java.util.*;

public class Order {
	List<Item> items;
	private PaymentInfo paymentInfo;
	private ShippingInfo shippingInfo;
	public Order() {
		items = new ArrayList<Item>();
	}
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public ShippingInfo getShippingInfo() {
		return shippingInfo;
	}

	public void setShippingInfo(ShippingInfo shippingInfo) {
		this.shippingInfo = shippingInfo;
	}

	@Override
	public String toString() {
		return "Order [items=" + items + "]";
	}
}
