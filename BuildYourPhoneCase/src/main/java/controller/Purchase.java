package controller;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Order;
import model.PaymentInfo;
import model.Item;
import model.ShippingInfo;


@Controller
@RequestMapping("/purchase")
public class Purchase {
	
	 
	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 request.setAttribute("itemAttribute", new Item());
		 //current products and their storage pulling from the db 
		 int storage = 100 ; 
		 Item iphone9 = new Item("iphone9Case", "13",storage); 
		 Item iphone10 = new Item("iphone10Case", "13",storage); 
		 Item iphone11 = new Item("iphone11Case", "13",storage); 
		 
		 
		//pass all products info to .jsp
		ArrayList<Item> items = new ArrayList<Item>() ; 	 
		items .add(iphone9) ; 
		items .add(iphone10) ; 
		items .add(iphone11) ; 
		Order product = new Order(); 
		product.setItems(items );
		request.setAttribute("product", product);
		 
		return "OrderEntryForm";
	}
	
	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String viewShippingEntryForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("shippingInfo", new ShippingInfo()) ; 
		return "ShippingEntryForm";
	}
	
	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntryForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("paymentInfo", new PaymentInfo()) ; 
		return "PaymentEntryForm";
	}

	
	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Order order = (Order) request.getSession().getAttribute("order") ; 
		ShippingInfo shippingInfo = (ShippingInfo) request.getSession().getAttribute("shippingInfo") ; 
		PaymentInfo paymentInfo = (PaymentInfo) request.getSession().getAttribute("paymentInfo") ; 
		
		//calculate total price 
		ArrayList<Item> items = order.getItems() ; 
		int sum =0; 
		for (Item item: items) {
			sum+= Integer.parseInt(item.getPrice())* item.getQuantity() ; 
		}
		request.setAttribute("sum", sum) ; 
		request.setAttribute("order", order) ; 
		request.setAttribute("shippingInfo", shippingInfo) ; 
		request.setAttribute("paymentInfo", paymentInfo) ; 
		
		
		return "ViewOrder";
	}
	
	@RequestMapping(path = "/viewConfirmation", method = RequestMethod.GET)
	public String viewConfirmation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("orderId", "123456") ; 
		request.setAttribute("greeting", "Thank you for your order! ") ; 
		return "Confirmation";
	}
	
	@RequestMapping(path = "/shoppingCart", method = RequestMethod.GET)
	public String shoppingCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int storage =100 ;
		Order order = (Order) request.getSession().getAttribute("order") ; 
		request.setAttribute("order", order);
		request.setAttribute("storage", storage);
		request.setAttribute("itemNum", order.getItems().size() ); 
	 
		return "shoppingCart";
	}
	
	
	@RequestMapping(path = "/addToCart", method = RequestMethod.POST)
	public String addItemToCart(@ModelAttribute("JustAnAttributeName")Item itemInCart, HttpServletRequest request) {
		Order order  ; 
		if (request.getSession().getAttribute("order") == null ) {
			order = new Order(); 
			
		}else {
			order =(Order) request.getSession().getAttribute("order") ;
		}
		
		if(itemInCart.getName() !=null && itemInCart.getPrice() !=null  ) {

			if(order.getItems().contains(itemInCart)) {
				//update quantity
				Item tempItem = order.getItems().get(order.getItems().indexOf(itemInCart)) ;
				int newQuant = tempItem.getQuantity() +1; 
				tempItem.setQuantity(newQuant) ; 
			}else {
				itemInCart.setQuantity(1) ; 
				order.getItems().add(itemInCart) ; 
			}
			
		} 
		request.getSession().setAttribute("order", order );     
		return "redirect:/purchase/shoppingCart";
		}
	 
	
	
	
	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("JustAnAttributeName") Order order, HttpServletRequest request) {
		request.getSession().setAttribute("order", order);
		
		String buttonTriggered = request.getParameter("button") ; 
		if(buttonTriggered !=null) {
		 
			if(buttonTriggered.equals("Continue Shopping")) {
				return "redirect:/purchase";
			}else if(buttonTriggered.equals("Purchase")){
				return "redirect:/purchase/shippingEntry";		
			}  
		}
		//delete
		//update order 
		int cartSize = order.getItems().size() ; 
		for(int i=0; i<cartSize; i++) {
			buttonTriggered = request.getParameter(String.valueOf(i)) ; 
			System.out.print("testing-------" + buttonTriggered ) ; 
			if(buttonTriggered !=null) {
				order.getItems().remove(i) ; 
			}
		}			 
		 request.setAttribute("order", order) ; 
		 request.getSession().setAttribute("order", order);
		 return "redirect:/purchase/shoppingCart";
		 
		
	
	}
	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo, HttpServletRequest request) {
		request.getSession().setAttribute("shippingInfo", shippingInfo);
		//System.out.print("------------TEST ------------"+ shippingInfo.getName()) ; 
		
		return "redirect:/purchase/paymentEntry";
		}
	
	
	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("paymentInfo")  PaymentInfo paymentInfo, HttpServletRequest request) {
		request.getSession().setAttribute("paymentInfo", paymentInfo);
		//System.out.print("------------TEST ------------"+ paymentInfo.getCardNum()) ; 
		 
		return "redirect:/purchase/viewOrder";
		}
	
	
	
	
	@RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
	public String confirmation(  HttpServletRequest request) {
		//stop session 
		 request.getSession().invalidate() ;
		return "redirect:/purchase/viewConfirmation";
		}
	
	
	
	@RequestMapping(path = "/keepShopping", method = RequestMethod.POST)
	public String keepShopping(  HttpServletRequest request) {
		 
		return "redirect:/purchase";
		}
	
	
	
	
	
}
