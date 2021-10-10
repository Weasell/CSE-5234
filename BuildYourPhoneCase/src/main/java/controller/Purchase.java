package controller;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Order;
import model.PaymentInfo;
import model.ServiceFacade;
import model.Item;
import model.ShippingInfo;

@Controller
@RequestMapping("/purchase")
public class Purchase {

	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// need to initialize an item corresponding to the modelAttribute object inside
		// the jsp file
		request.setAttribute("itemAttribute", new Item());

		int storage = 100;
		request.setAttribute("storage", storage);
		
		ServiceFacade serviceFacade = new ServiceFacade();
		List<Item> items = serviceFacade.getAvailableItems();
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
		// FIXME
		request.setAttribute("orderId", "123456");
		request.setAttribute("greeting", "Thank you for your order! ");
		return "Confirmation";
	}

	@RequestMapping(path = "/addToCart", method = RequestMethod.POST)
	public String addItemToCart(@ModelAttribute("JustAnAttributeName") Item itemInCart, HttpServletRequest request) {
		Order order = (Order) request.getSession().getAttribute("order");
		// set imagePath, name, price by id
		setFullItemInfo(itemInCart);
		itemInCart.setQuantity(1);
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

		return "redirect:/purchase ";
	}

	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("JustAnAttributeName") Order order, HttpServletRequest request) {
		// reset name, price, images by id
		for (int i = 0; i < order.getItems().size(); i++) {
			Item item = order.getItems().get(i);
			setFullItemInfo(item);

		}

		String buttonTriggered = request.getParameter("button");
		// check if button "checkout" is pressed
		if (buttonTriggered != null) {
			request.getSession().setAttribute("order", order);
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
				order.getItems().remove(i);
			}
		}

		request.getSession().setAttribute("order", order);
		return "redirect:/purchase ";

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
		// stop session
		request.getSession().invalidate();
		return "redirect:/purchase/viewConfirmation";
	}

	@RequestMapping(path = "/keepShopping", method = RequestMethod.POST)
	public String keepShopping(HttpServletRequest request) {
		return "redirect:/purchase";
	}

//Helper method

	// FIXME
	private void setFullItemInfo(Item item) {
		int id = item.getId();
		String name = item.getName();
		double price = item.getPrice();
		String imagePath = item.getImage();

		item.setName(name);
		item.setPrice(price);
		item.setImage(imagePath);
	}

	private double calculateTotalPrice(Order order) {
		List<Item> items = order.getItems();
		double sum = 0.0;
		for (Item item : items) {
			double currentPrice = item.getPrice();
			double currentQuan = (double) item.getQuantity();
			// sum += item.getPrice() * (double)item.getQuantity() ;
			sum += currentPrice * currentQuan;
		}
		return sum;
	}

	private int calculateCartSize(Order order) {
		List<Item> items = order.getItems();
		int size = 0;
		for (Item item : items) {
			size += item.getQuantity();
		}
		return size;
	}

}
