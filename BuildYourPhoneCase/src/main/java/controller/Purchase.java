package controller;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Order;
import model.PaymentInfo;
import model.Item;
import model.ShippingInfo;
import utils.ServiceFacade;
import vo.cartInfo;

@Controller
@RequestMapping("/purchase")
public class Purchase {

	ServiceFacade serviceFacade = new ServiceFacade();
	
	@RequestMapping( method = RequestMethod.GET)
	public String viewOrderEntryForm(HttpServletRequest request, HttpServletResponse response, @RequestParam("pageNum") int pageNum) throws Exception {
		// need to initialize an item corresponding to the modelAttribute object inside
		// the jsp file
		request.setAttribute("itemAttribute", new Item());
		
		 
		//save pageNum in session 
		request.getSession().setAttribute("pageNum", pageNum);
		
		
		List<Item> items = serviceFacade.getAvailableItems(pageNum);
		Order product = new Order();
		product.setItems(items);
		request.setAttribute("product", product);
		 
		// check if there is a anything stored in the cart
		Order order;
		if (request.getSession().getAttribute("order") == null) {
			// initialize the session scope Order object for the first time
			order = new Order();
		} else {
			order = (Order) request.getSession().getAttribute("order");
		}

		request.setAttribute("order", order);
		request.getSession().setAttribute("order", order);

		// check duplicate item in the cart
		if (request.getSession().getAttribute("duplicateItem") == null) {
			request.getSession().setAttribute("duplicateItem", "");
		}
		if (request.getSession().getAttribute("maxOrderNum") == null) {
			request.getSession().setAttribute("maxOrderNum", "");
		}
		 

		// calculate total price and number of items in the cart
		double sum = calculateTotalPrice(order);
		int cartSize = calculateCartSize(order);

		request.setAttribute("sum", sum);
		request.setAttribute("cartSize", cartSize);
		 
		 
		return "OrderEntryForm";
	}

	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String viewShippingEntryForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("shippingInfo", new ShippingInfo());
		return "ShippingEntryForm";
	}

	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntryForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("paymentInfo", new PaymentInfo());
		return "PaymentEntryForm";
	}

	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get info from session scope model
		Order order = (Order) request.getSession().getAttribute("order");
		ShippingInfo shippingInfo = (ShippingInfo) request.getSession().getAttribute("shippingInfo");
		PaymentInfo paymentInfo = (PaymentInfo) request.getSession().getAttribute("paymentInfo");
		// calculate total price
		double sum = calculateTotalPrice(order);
		request.setAttribute("sum", sum);
		request.setAttribute("order", order);
		request.setAttribute("shippingInfo", shippingInfo);
		request.setAttribute("paymentInfo", paymentInfo);

		return "ViewOrder";
	}

	@RequestMapping(path = "/viewConfirmation", method = RequestMethod.GET)
	public String viewConfirmation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 

		//send order info to microservice and get confirmatin number 
		Order order = (Order) request.getSession().getAttribute("order");
		ShippingInfo shippingInfo = (ShippingInfo) request.getSession().getAttribute("shippingInfo");
		PaymentInfo paymentInfo = (PaymentInfo) request.getSession().getAttribute("paymentInfo");
		order.setPaymentInfo(paymentInfo);
		order.setShippingInfo(shippingInfo);
		System.out.println(order) ;
		String confirmNum = serviceFacade.orderProcess((Order)request.getSession().getAttribute("order")) ;
		request.setAttribute("orderId", confirmNum);
		request.setAttribute("greeting", "Thank you for your order! ");
		// stop session
		request.getSession().invalidate();
		return "Confirmation";
	}

 @RequestMapping(path = "/addToCart", method = RequestMethod.POST)
	public String addItemToCart(@ModelAttribute("JustAnAttributeName") Item itemInCart, HttpServletRequest request) {
 	   
		Order order = (Order) request.getSession().getAttribute("order");
		// set imagePath, name, price by id
		int id = itemInCart.getId();
		itemInCart = serviceFacade.getItemById(id );
		itemInCart.setAvailableQuantity(1);
		 
		// update order info
		if (order.getItems().contains(itemInCart)) {
			// alert: already in the cart
			request.getSession().setAttribute("duplicateItem", itemInCart.getName());

		} else {
			// add new selected item into the cart
			order.getItems().add(itemInCart);
			request.getSession().setAttribute("duplicateItem", "");
		}

		request.getSession().setAttribute("order", order);
		
		int pageNum = (int)request.getSession().getAttribute("pageNum" );
		return "redirect:/purchase?pageNum="+pageNum; 
	}
	 

	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("JustAnAttributeName") Order order, HttpServletRequest request) {
		 
		 
		 
		boolean quantityAvail = true ; 
		request.getSession().setAttribute("maxOrderNum", "");
		
		
		 
		// reset name, price, images by id
		List<Item> items =new ArrayList<Item>() ;
		for (int i = 0; i < order.getItems().size(); i++) {
			Item item = serviceFacade.getItemById(order.getItems().get(i).getId() ) ; 
			int storage  = item.getAvailableQuantity() ; 
			System.out.print(storage) ; 
			int requestNum = order.getItems().get(i).getAvailableQuantity() ; 
			
			item.setAvailableQuantity(order.getItems().get(i).getAvailableQuantity()) ; 
			//FIXME 
			//check if we have enough storage
			if(requestNum<=storage) {
				item.setAvailableQuantity(requestNum) ; 
				}else {
				//alter the max number customers can buy
				quantityAvail = false ;
				String message= "The max number of "+ item.getName()+" that can be bought is "+ storage; 
			    request.getSession().setAttribute("maxOrderNum", message);
				
			}
			
			items.add(item) ; 	
		}
		order.setItems(items) ; 

		String buttonTriggered = request.getParameter("button");
		// check if button "checkout" is pressed
		if (buttonTriggered != null && quantityAvail ) {
			request.getSession().setAttribute("order", order);
			System.out.println(order) ;
			return "redirect:/purchase/shippingEntry";
		}

		// remove the duplicate item warning from the UI
		request.getSession().setAttribute("duplicateItem", "");

		// delete or update quantity
		int cartSize = order.getItems().size();
		for (int i = 0; i < cartSize; i++) {
			buttonTriggered = request.getParameter(String.valueOf(i));
			if (buttonTriggered != null) {
				// delete
				 request.getSession().setAttribute("maxOrderNum", "");
				order.getItems().remove(i);
			}
		}

		request.getSession().setAttribute("order", order);
		int pageNum = (int)request.getSession().getAttribute("pageNum" );
		return "redirect:/purchase?pageNum="+pageNum; 
		 

	}

	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo,
			HttpServletRequest request) {
		request.getSession().setAttribute("shippingInfo", shippingInfo);

		return "redirect:/purchase/paymentEntry";
	}

	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("paymentInfo") PaymentInfo paymentInfo, HttpServletRequest request) {
		request.getSession().setAttribute("paymentInfo", paymentInfo);

		return "redirect:/purchase/viewOrder";
	}

	@RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
	public String confirmation(HttpServletRequest request) {
		
		return "redirect:/purchase/viewConfirmation";
	}

	@RequestMapping(path = "/keepShopping", method = RequestMethod.POST)
	public String keepShopping(HttpServletRequest request) {
		return "redirect:/purchase?pageNum=1";
	}

//Helper method


	private double calculateTotalPrice(Order order) {
		List<Item> items = order.getItems();
		double sum = 0.0;
		for (Item item : items) {
			double currentPrice = item.getPrice();
			double currentQuan = (double) item.getAvailableQuantity();
			sum += currentPrice * currentQuan;
		}
		return Math.round(sum* 100)/ 100.0;
		 
	}

	private int calculateCartSize(Order order) {
		List<Item> items = order.getItems();
		int size = 0;
		for (Item item : items) {
			size += item.getAvailableQuantity();
		}
		return size;
	}
	
	
	//ajax 
	/*
	//testing 
	@ResponseBody
	@RequestMapping(path = "/testing",  method = RequestMethod.POST)
	public String testingMethod(@RequestBody String data) {  
		System.out.println(data) ;
		String result ="this is a new string for test" ;
		 
		return result;

	}
	//addToCart
		@ResponseBody
		@RequestMapping(path = "/addToCartAjax",  method = RequestMethod.POST)
		public cartInfo addToCartAjax(@RequestBody String str, HttpServletRequest request ) {  
		
			int id = Character.getNumericValue (str.charAt(str.length() - 1)) ; 
			System.out.println(id) ;
			
			Item itemInCart = serviceFacade.getItemById(id);
			itemInCart.setAvailableQuantity(1);
			 
			Order order = (Order) request.getSession().getAttribute("order");
			// update order info
			if (order.getItems().contains(itemInCart)) {
				// alert: already in the cart
				request.getSession().setAttribute("duplicateItem", itemInCart.getName());

			} else {
				// add new selected item into the cart
				order.getItems().add(itemInCart);
				request.getSession().setAttribute("duplicateItem", "");
			}

			request.getSession().setAttribute("order", order);

			//data needed:  duplicate item , cart size , order
			double sum = calculateTotalPrice(order);
			int cartSize = calculateCartSize(order);
			cartInfo cart = new cartInfo((String)request.getSession().getAttribute("duplicateItem"), 
					(String)request.getSession().getAttribute("maxOrderNum"),		cartSize,  sum, order	) ; 
			
			 
			return cart;

		}
		*/
}
