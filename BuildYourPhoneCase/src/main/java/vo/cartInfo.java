package vo;

import model.Order;

public class cartInfo {
	String duplicateItem ; 
	String maxOrderNum ; 
	int cartSize ; 
	double sum ;
	Order order;
	
	
	public cartInfo (String di, String mon, int size,double sum, Order or) {
		this.duplicateItem =di ;
		this.maxOrderNum = mon ; 
		this.cartSize = size ; 
		this.sum = sum;
		this.order =or;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public String getDuplicateItem() {
		return duplicateItem;
	}
	public void setDuplicateItem(String duplicateItem) {
		this.duplicateItem = duplicateItem;
	}
	public String getMaxOrderNum() {
		return maxOrderNum;
	}
	public void setMaxOrderNum(String maxOrderNum) {
		this.maxOrderNum = maxOrderNum;
	}
	public int getCartSize() {
		return cartSize;
	}
	public void setCartSize(int cartSize) {
		this.cartSize = cartSize;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "cartInfo [duplicateItem=" + duplicateItem + ", maxOrderNum=" + maxOrderNum + ", cartSize=" + cartSize
				+ ", sum=" + sum + ", order=" + order + "]";
	} 
	
	
}
