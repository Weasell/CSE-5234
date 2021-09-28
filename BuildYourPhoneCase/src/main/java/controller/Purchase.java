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
		 
		
		ArrayList<Item> items = new ArrayList<Item>() ; 
		int storage = 100 ; 
		items .add(new Item("iphone9Case", "13",storage)) ; 
		items .add(new Item("iphone10Case", "13",storage)) ; 
		items .add(new Item("iphone11Case", "13",storage)) ; 
		items .add(new Item("iphone12Case", "13", storage)) ; 
		items .add(new Item("iphone13Case", "13",storage)) ; 
		 
		Order product = new Order(); 
		product.setItems(items );
		request.setAttribute("product", product);
		request.setAttribute("storage", storage);
		
		/*Order order = new Order() ; 
		ArrayList<Item> purchases = new ArrayList<Item>() ; 
		purchases.add(new Item("iphone9Case", "13", 1) ); 
		order.setItems(purchases);
		request.setAttribute("order", order);  */

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
	
	
	 
	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("JustAnAttributeName") Order order, HttpServletRequest request) {
		request.getSession().setAttribute("order", order);
		//System.out.print(shippingInfo.getName()) ; 
		return "redirect:/purchase/shippingEntry";
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
		return "redirect:/purchase/viewConfirmation";
		}
	
	
	
	@RequestMapping(path = "/keepShopping", method = RequestMethod.POST)
	public String keepShopping(  HttpServletRequest request) {
		return "redirect:/purchase";
		}
	
	
	
	
	
	
}
