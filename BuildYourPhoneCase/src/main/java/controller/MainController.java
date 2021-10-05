package controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Order;
import model.ShippingInfo;

@Controller
@RequestMapping("/")

public class MainController {
	@RequestMapping(method = RequestMethod.GET)
	public String viewHomePage(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		Order order = (Order)request.getSession().getAttribute("order");
		request.setAttribute("order", order);
		return "home";
	}
	
	@RequestMapping(path = "/about", method = RequestMethod.GET)
	public String viewAboutUs(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Order order = (Order)request.getSession().getAttribute("order");
		request.setAttribute("order", order);
		return "about";
	}
	@RequestMapping(path = "/contactus", method = RequestMethod.GET)
	public String viewContactUS(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Order order = (Order)request.getSession().getAttribute("order");
		request.setAttribute("order", order);
		return "ContactUs";
	}
	
}
