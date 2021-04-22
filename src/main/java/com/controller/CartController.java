package com.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.ItemDetailsDTO;
import com.model.OrderDetails;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.service.ShoppingService;

@Controller
@RequestMapping("cart")
public class CartController {
	
	@Autowired
	private ShoppingService shoppingService;
	
	@RequestMapping(value="showCart", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView showCart(ModelAndView mandv,HttpServletRequest request,Model model){
		HttpSession session = request.getSession();
		Boolean isCartUpdated = (Boolean)session.getAttribute("cartUpdateFlag");
		if(isCartUpdated) {
			mandv.setViewName("redirect:/cart/updatedCart");
		}
		else {
			mandv.setViewName("redirect:/cart/newCart");
		}
		return mandv; 
	}
	
	@RequestMapping(value="newCart", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView newCart(ModelAndView mandv,HttpServletRequest request,Model model){
		HttpSession session = request.getSession();
		HashMap<Integer,Integer> selecteditems =(HashMap<Integer,Integer>)session.getAttribute("selecteditems");
		
		HashMap<ItemDetailsDTO,Integer> finalItems = new HashMap<ItemDetailsDTO, Integer>(); 
		for (Map.Entry<Integer, Integer> set : selecteditems.entrySet()) {
			String itemName = shoppingService.getItemName(set.getKey());
			ItemDetailsDTO item = shoppingService.getItemByName(itemName);
			finalItems.put(item, set.getValue());
		}
		session.setAttribute("items", finalItems);
		
		String uname = (String)session.getAttribute("uname");
		Integer uid = (Integer)session.getAttribute("uid");
		
		Double total = shoppingService.getTotal(finalItems);
		session.setAttribute("total", total);
		
		mandv.addObject("date",LocalDate.now());
		mandv.addObject("uname",uname);
		mandv.addObject("uid",uid);
		mandv.addObject("total",total);
		mandv.addObject("items",finalItems);
		mandv.setViewName("cart"); 
		OrderDetails orderDetails = new OrderDetails();
		model.addAttribute("orderDetails", orderDetails);
			
		return mandv;
	}
	
	@RequestMapping(value="updatedCart", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView updatedCart(ModelAndView mandv,HttpServletRequest request,Model model){
		HttpSession session = request.getSession();
		HashMap<ItemDetailsDTO,Integer> finalItems = (HashMap<ItemDetailsDTO,Integer>)session.getAttribute("items");
		session.setAttribute("items", finalItems);
		
		String uname = (String)session.getAttribute("uname");
		Integer uid = (Integer)session.getAttribute("uid");
		
		Double total = shoppingService.getTotal(finalItems);
		session.setAttribute("total", total);
		
		mandv.addObject("date",LocalDate.now());
		mandv.addObject("uname",uname);
		mandv.addObject("uid",uid);
		mandv.addObject("total",total);
		mandv.addObject("items",finalItems);
		mandv.setViewName("cart"); 
		OrderDetails orderDetails = new OrderDetails();
		model.addAttribute("orderDetails", orderDetails);
			
		return mandv;
	}
	
	@PostMapping(value="order")
	public ModelAndView createOrder(@ModelAttribute("amount") OrderDetails orderDetails,ModelAndView mandv,HttpServletRequest request) throws RazorpayException {
		HttpSession session = request.getSession();
		
		RazorpayClient razorpayClient = new RazorpayClient("rzp_test_uwFPahVNP7SemQ", "6REjsUiIJAWvnQvIRf40BXA7");
		JSONObject options = new JSONObject();

		double amount2=Double.parseDouble(orderDetails.getAmount())*100;
		int amount = (int)amount2;
		options.put("amount",amount);
		options.put("currency", "INR");
		options.put("receipt", "txn_123456");
		Order order = razorpayClient.Orders.create(options);
		
		mandv.addObject("amt",amount);
		mandv.addObject("order_id",order.get("id"));

		
		HashMap<ItemDetailsDTO,Integer> finalItems = (HashMap<ItemDetailsDTO,Integer>)session.getAttribute("items");
		session.setAttribute("items", finalItems);
		
		String uname = (String)session.getAttribute("uname");
		Integer uid = (Integer)session.getAttribute("uid");
		Double total = shoppingService.getTotal(finalItems);
		session.setAttribute("total", total);
		
		mandv.addObject("date",LocalDate.now());
		mandv.addObject("uname",uname);
		mandv.addObject("uid",uid);
		mandv.addObject("total",total);
		mandv.addObject("items",finalItems);
		
		mandv.setViewName("payment");
		return mandv;
		
	}
	
	@RequestMapping(value="remove", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView remove(ModelAndView mandv,HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
	
		int id=Integer.parseInt(request.getParameter("selected"));
		HashMap<ItemDetailsDTO,Integer> finalItems = (HashMap<ItemDetailsDTO,Integer>)session.getAttribute("items");
		
		String itemName = shoppingService.getItemName(id);
		finalItems.remove(shoppingService.getItemByName(itemName));
		session.setAttribute("items", finalItems);
		
		String uname = (String)session.getAttribute("uname");
		Integer uid = (Integer)session.getAttribute("uid");
		Double total = shoppingService.getTotal(finalItems);
		session.setAttribute("total", total);
		
		mandv.addObject("date",LocalDate.now());
		mandv.addObject("uname",uname);
		mandv.addObject("uid",uid);
		mandv.addObject("total",total);
		mandv.addObject("items",finalItems);
		mandv.setViewName("cart"); 
		OrderDetails orderDetails = new OrderDetails();
		model.addAttribute("orderDetails", orderDetails);
		
		session.setAttribute("cartUpdateFlag", true);
		return mandv; 

	}

	@RequestMapping(value="redirectToServices", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView redirectToSuccess(ModelAndView mandv,HttpServletRequest request) {
		mandv.setViewName("redirect:/invoice/paymentSuccess");
		return mandv;
	}
	
	@RequestMapping(value="logout", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView logout(ModelAndView mandv,HttpServletRequest request) {
		mandv.setViewName("redirect:/login/logout");
		return mandv;
	}
	
	@RequestMapping(value="home", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView home(ModelAndView mandv,HttpServletRequest request) {
		mandv.setViewName("redirect:/login/home");
		return mandv;
	}

	@RequestMapping(value="shopping1", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView shopping(HttpServletRequest request, ModelAndView mandv) {
		
		mandv.setViewName("redirect:/shopping/shopping1");
		return mandv;
	}
	
	@RequestMapping(value="shopping2", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView shopping2(HttpServletRequest request, ModelAndView mandv) {
		
		mandv.setViewName("redirect:/shopping/shopping2");
		return mandv;
	}
	
	@RequestMapping(value="shopping3", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView shopping3(HttpServletRequest request, ModelAndView mandv) {
		
		mandv.setViewName("redirect:/shopping/shopping3");
		return mandv;
	}
	
}
