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
		 request.setAttribute("storage", storage);
		 Item iphone9 = new Item( 0); 
		 Item iphone10 = new Item( 1); 
		 Item iphone11 = new Item( 2); 
		 
		 
		//pass all products info to .jsp
		ArrayList<Item> items = new ArrayList<Item>() ; 	 
		items .add(iphone9) ; 
		items .add(iphone10) ; 
		items .add(iphone11) ; 
		Order product = new Order(); 
		product.setItems(items );
		request.setAttribute("product", product);
		
		//check if there is a anything stored in the cart 
		Order order  ; 
		if (request.getSession().getAttribute("order") == null ) {
			order = new Order(); 
			
			
		}else {
			order =(Order) request.getSession().getAttribute("order") ;
		}
		
		
		
		
		request.setAttribute("order", order);
		request.getSession().setAttribute("order", order) ; 
		
		//check duplicate item in the cart
		if(request.getSession().getAttribute("duplicateItem") ==null)
		{
			request.getSession().setAttribute("duplicateItem", "")   ;
		}
		
		
		//calculate total price
		ArrayList<Item> itemsInCart = order.getItems() ; 
		int sum =0; 
		int cartSize = 0 ; 
		for (Item item: itemsInCart) {
			sum+=  item.getPriceById(item.getId())* item.getQuantity() ; 
			cartSize += item.getQuantity() ; 
		}
		request.setAttribute("sum", sum) ; 
		request.setAttribute("cartSize", cartSize);
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
			sum+=  item.getPriceById(item.getId())* item.getQuantity() ; 
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
//FIXME	
	@RequestMapping(path = "/shoppingCart", method = RequestMethod.GET)
	public String shoppingCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int storage =100 ;
		Order order = (Order) request.getSession().getAttribute("order") ; 
		//request.setAttribute("order", order);
		request.setAttribute("storage", storage);
		request.setAttribute("itemNum", order.getItems().size() ); 
	 
		return "shoppingCart";
	}
	
	
	@RequestMapping(path = "/addToCart", method = RequestMethod.POST)
	public String addItemToCart(@ModelAttribute("JustAnAttributeName")Item itemInCart, HttpServletRequest request) {
		Order order =(Order) request.getSession().getAttribute("order") ; 
		//set imagePath, name, price by id
		int id = itemInCart.getId() ; 
		String name = itemInCart.getNameById(id); 
		int price = itemInCart.getPriceById(id); 
		String imagePath = itemInCart.getImagePathById(id); 
	    
	    itemInCart.setName(name) ; 
	    itemInCart.setPrice(price) ; 
	    itemInCart.setImage(imagePath) ;
	    itemInCart.setQuantity(1) ; 
		//update order info
			if(order.getItems().contains(itemInCart)) {	
				//FIXME
				//alert: already in the cart 
				request.getSession().setAttribute("duplicateItem", itemInCart.getName())   ;
				 
			}else {
				 
				
				order.getItems().add(itemInCart) ; 
				request.getSession().setAttribute("duplicateItem", "")   ;
			}
			
		 
		request.getSession().setAttribute("order", order );    
		//FIXME
		return "redirect:/purchase ";
		}
	 
	
	
	
	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("JustAnAttributeName") Order order, HttpServletRequest request) {
		//reset name, price, images here 
		for (int i=0; i<order.getItems().size(); i++) {
			
			Item item = order.getItems().get(i) ; 
			int id = item.getId() ; 
			String name = item.getNameById(id) ; 
			int price = item.getPriceById(id) ; 
			String path = item.getImagePathById(id) ; 
			item.setName(name) ; 
			item.setPrice(price) ; 
			item.setImage(path);
		}
		
		
		String buttonTriggered = request.getParameter("button") ; 
		if(buttonTriggered !=null) {
			request.getSession().setAttribute("order", order);
			return "redirect:/purchase/shippingEntry";		
 
		}
		 
		request.getSession().setAttribute("duplicateItem", "")   ;
		//delete or update quantity
		 
		int cartSize = order.getItems().size() ; 
		for(int i=0; i<cartSize; i++) {
			buttonTriggered = request.getParameter(String.valueOf(i)) ; 
			System.out.print("testing-------" + buttonTriggered ) ; 
			if(buttonTriggered !=null) {
				 
				//delete
				order.getItems().remove(i) ; 
				
			}
		}	
		 
		 //request.setAttribute("order", order) ; 
		 request.getSession().setAttribute("order", order);
		 return "redirect:/purchase ";
		 
		
	
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
