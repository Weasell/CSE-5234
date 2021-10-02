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
		//need to initialize an item corresponding to the modelAttribute object inside the jsp file
		 request.setAttribute("itemAttribute", new Item());
		 
		 int storage = 100 ; 
		 request.setAttribute("storage", storage);
		 
		 //FIXME: current products and their storage pulling from the db 
		 Item iphone9 = new Item( 0); 
		 Item iphone10 = new Item( 1); 
		 Item iphone11 = new Item( 2); 
		 Item iphone12 = new Item( 3); 
		 Item iphone13 = new Item( 4); 
		 Item iphoneX = new Item( 5); 
		 
		//FIXME: pass all products info to .jsp
		ArrayList<Item> items = new ArrayList<Item>() ; 	 
		items .add(iphone9) ; 
		items .add(iphone10) ; 
		items .add(iphone11) ; 
		items .add(iphone12) ; 
		items .add(iphone13) ; 
		items .add(iphoneX) ; 
		Order product = new Order(); 
		product.setItems(items );
		request.setAttribute("product", product);
		
		//check if there is a anything stored in the cart 	
		Order order  ; 
		if (request.getSession().getAttribute("order") == null ) {
			//initialize the session scope Order object for the first time 
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
		
		
		//calculate total price and number of items in the cart
		int sum = calculateTotalPrice(order); 
		int cartSize = calculateCartSize(order); 
		 
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
		//get info from session scope model
		Order order = (Order) request.getSession().getAttribute("order") ; 
		ShippingInfo shippingInfo = (ShippingInfo) request.getSession().getAttribute("shippingInfo") ; 
		PaymentInfo paymentInfo = (PaymentInfo) request.getSession().getAttribute("paymentInfo") ; 
		
		//calculate total price 
		int sum = calculateTotalPrice( order) ; 
		request.setAttribute("sum", sum) ; 
		request.setAttribute("order", order) ; 
		request.setAttribute("shippingInfo", shippingInfo) ; 
		request.setAttribute("paymentInfo", paymentInfo) ; 
		
		
		return "ViewOrder";
	}
	
	@RequestMapping(path = "/viewConfirmation", method = RequestMethod.GET)
	public String viewConfirmation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FIXME
		request.setAttribute("orderId", "123456") ; 
		request.setAttribute("greeting", "Thank you for your order! ") ; 
		return "Confirmation";
	}
 
	
	
	@RequestMapping(path = "/addToCart", method = RequestMethod.POST)
	public String addItemToCart(@ModelAttribute("JustAnAttributeName")Item itemInCart, HttpServletRequest request) {
		Order order =(Order) request.getSession().getAttribute("order") ; 
		//set imagePath, name, price by id
		setFullItemInfo(itemInCart) ;
	    itemInCart.setQuantity(1) ; 
		//update order info
			if(order.getItems().contains(itemInCart)) {			 
				//alert: already in the cart 
				request.getSession().setAttribute("duplicateItem", itemInCart.getName())   ;
				 
			}else {
				//add new selected item into the cart			
				order.getItems().add(itemInCart) ; 
				request.getSession().setAttribute("duplicateItem", "")   ;
			}		
		 
		request.getSession().setAttribute("order", order );    
		 
		return "redirect:/purchase ";
		}
	 
	
	
	
	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("JustAnAttributeName") Order order, HttpServletRequest request) {
		//reset name, price, images by id
		for (int i=0; i<order.getItems().size(); i++) {
			Item item = order.getItems().get(i) ; 
			setFullItemInfo(item) ;
			 
		}
		
	
		String buttonTriggered = request.getParameter("button") ; 
		//check if button "checkout" is pressed 
		if(buttonTriggered !=null) {
			request.getSession().setAttribute("order", order);
			return "redirect:/purchase/shippingEntry";		
		}
		
		//remove the duplicate item warning from the UI
		request.getSession().setAttribute("duplicateItem", "")   ;
		
		//delete or update quantity	 
		int cartSize = order.getItems().size() ; 
		for(int i=0; i<cartSize; i++) {
			buttonTriggered = request.getParameter(String.valueOf(i)) ; 
			if(buttonTriggered !=null) { 
				//delete
				order.getItems().remove(i) ; 			
			}
		}	
		 
		 request.getSession().setAttribute("order", order);
		 return "redirect:/purchase ";
		 
		
	
	}
	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo, HttpServletRequest request) {
		request.getSession().setAttribute("shippingInfo", shippingInfo);
		
		return "redirect:/purchase/paymentEntry";
		}
	
	
	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("paymentInfo")  PaymentInfo paymentInfo, HttpServletRequest request) {
		request.getSession().setAttribute("paymentInfo", paymentInfo);
		 
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
	
	
	
//Helper method
	
	//FIXME
	private void setFullItemInfo(Item item) {
		int id = item.getId() ; 
		String name = item.getNameById(id); 
		int price = item.getPriceById(id); 
		String imagePath = item.getImagePathById(id); 
	    
	    item.setName(name) ; 
	    item.setPrice(price) ; 
	    item.setImage(imagePath) ;
		
	}
	
	private int calculateTotalPrice(Order order) {
		ArrayList<Item> items = order.getItems() ; 
		int sum =0; 
		for (Item item: items) {
			sum+=  item.getPriceById(item.getId())* item.getQuantity() ; 
		}
		return sum ;
	}
	
	private int calculateCartSize(Order order) {
		ArrayList<Item> items = order.getItems() ; 
		int size =0; 
		for (Item item: items) {
			size+=  item.getQuantity() ; 
		}
		return size ;
	}
	
	
	
}
