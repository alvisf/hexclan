package com.controller;

import java.io.Serializable;
import java.net.http.HttpRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.model.UserDetailsDTO;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.service.ShoppingService;
import com.service.ShoppingServiceImpl;


@Controller
@RequestMapping("shopping")
public class ShoppingController {
	
	@Autowired
	private ShoppingService shoppingService;
	
	private ShoppingFormBean shoppingFormBean;
	
	public ShoppingController() {
		shoppingFormBean=ShoppingFormBean.getShoppingFormBean();
	}

	public final ShoppingFormBean getShoppingFormBean() {
		return shoppingFormBean;
	}

	public final void setShoppingFormBean(ShoppingFormBean shoppingFormBean) {
		this.shoppingFormBean = shoppingFormBean;
	}

	public final ShoppingService getShoppingService() {
		return shoppingService;
	}

	public final void setShoppingService(ShoppingService shoppingService) {
		this.shoppingService = shoppingService;
	}

	@ModelAttribute("items")
	public List<ItemDetailsDTO> getModel(){
		List<ItemDetailsDTO> items = shoppingService.dispallitems("grocery");
		
		return items;
	}

	@RequestMapping(value="shop1", method=RequestMethod.GET)
	public ModelAndView loadShoppingForm(UserDetailsDTO user, ModelAndView mandv) { 
		//List<Integer> categories = shoppingService.getCategories();
		
		getModel();
		mandv.addObject("sfb",shoppingFormBean);
		mandv.setViewName("groceryshop");
		return mandv;
	}
	
	@RequestMapping(value="shopping1", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView shopping(HttpServletRequest request, ModelAndView mandv) {
		
		mandv.setViewName("redirect:/shopping/shop1");
		return mandv;
	}
	
	@RequestMapping(value="shopping2", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView shopping2(HttpServletRequest request, ModelAndView mandv) {
		
		mandv.setViewName("redirect:/shopping2/shop2");
		return mandv;
	}
	
	@RequestMapping(value="shopping3", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView shopping3(HttpServletRequest request, ModelAndView mandv) {
		
		mandv.setViewName("redirect:/shopping3/shop3");
		return mandv;
	}

	
	@RequestMapping(value="submitShoppingForm", method=RequestMethod.POST)
	public ModelAndView submitCheckBoxForm(ShoppingFormBean sfb,ModelAndView mandv,HttpServletRequest request) {
//		List<String> list = sfb.getItemlist();
//		List<String> itemList = new ArrayList<String>();
		HttpSession session = request.getSession();
		
		String[] selected=request.getParameterValues("selected");
		HashMap<Integer,Integer> selecteditems = (HashMap<Integer,Integer>)session.getAttribute("selecteditems");
		for(int i=0;i<selected.length;i++) {
			String qty=request.getParameter(selected[i]);
			selecteditems.put(Integer.parseInt(selected[i]),Integer.parseInt(qty));
			
		}
		
		
		session.setAttribute("selecteditems", selecteditems);
		System.out.println(selecteditems); 
		mandv.setViewName("groceryshop");
		return mandv;
	}	
	
	@RequestMapping(value="cart", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView showCart(ModelAndView mandv,HttpServletRequest request,Model model){
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
	
	@PostMapping(value="order")
	public ModelAndView createOrder(@ModelAttribute("amount") OrderDetails orderDetails,ModelAndView mandv,HttpServletRequest request) throws RazorpayException {
		
		RazorpayClient razorpayClient = new RazorpayClient("rzp_test_uwFPahVNP7SemQ", "6REjsUiIJAWvnQvIRf40BXA7");
		JSONObject options = new JSONObject();
//		OrderDetails order_info = new OrderDetails();

		System.out.println(orderDetails);
		double amount2=Double.parseDouble(orderDetails.getAmount())*100;
		int amount = (int)amount2;
		System.out.println(amount);
		options.put("amount",amount);
		options.put("currency", "INR");
		options.put("receipt", "txn_123456");
		Order order = razorpayClient.Orders.create(options);
		System.out.println(order);
		
		mandv.addObject("amt",amount);
		mandv.addObject("order_id",order.get("id"));
		mandv.setViewName("payment");
		
		
		
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
		

		return mandv;
		
	}
	
//	@RequestMapping(value="order", method= {RequestMethod.GET,RequestMethod.POST})
//	public ModelAndView confirmOrder(ModelAndView mandv,HttpServletRequest request) {
//		mandv.setViewName("redirect:/invoice/payment");
//		return mandv;
//	}
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
		mandv.setViewName("welcome");
		return mandv;
	}
	
	@RequestMapping(value="remove", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView remove(ModelAndView mandv,HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
	
		int id=Integer.parseInt(request.getParameter("selected"));
		System.out.println(id);
		
		HashMap<ItemDetailsDTO,Integer> finalItems = (HashMap<ItemDetailsDTO,Integer>)session.getAttribute("items");
		
		//finalItems.remove(itemDetailsDAO.getItemDetails(id));
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
		return mandv; 

	}
}
