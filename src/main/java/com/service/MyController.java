package com.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.OrderDetails;
import com.razorpay.Order;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;
import com.model.OrderDetails;
@Controller
@RequestMapping("hello")
public class MyController {
	

	
	@RequestMapping(value="test", method=RequestMethod.GET)
	public ModelAndView test(ModelAndView mandv,Model model) throws RazorpayException {
	OrderDetails orderDetails = new OrderDetails();
	model.addAttribute("orderDetails", orderDetails);
		System.out.println("home called");
		mandv.addObject("msg","df");
		mandv.setViewName("Welcome2");
		return mandv;
		
	}
	
	@PostMapping(value="order")
	public ModelAndView createOrder(@ModelAttribute("amount") OrderDetails orderDetails,ModelAndView mandv) throws RazorpayException {
		
		
		
		RazorpayClient razorpayClient = new RazorpayClient("rzp_test_uwFPahVNP7SemQ", "6REjsUiIJAWvnQvIRf40BXA7");
		JSONObject options = new JSONObject();
//		OrderDetails order_info = new OrderDetails();

		System.out.println(orderDetails);
		int amount=Integer.parseInt(orderDetails.getAmount());
		System.out.println(amount);
		options.put("amount",amount);
		options.put("currency", "INR");
		options.put("receipt", "txn_123456");
		Order order = razorpayClient.Orders.create(options);
		System.out.println(order);
		
		mandv.addObject("amt",amount);
		mandv.addObject("order_id",order.get("id"));
		mandv.setViewName("paid");
		return mandv;
		

		
	}
	
	@RequestMapping(value="verify", method=RequestMethod.POST)
	public ModelAndView checkoutPay(OrderDetails orderDetails,ModelAndView mandv) throws RazorpayException {
	
		
		
		JSONObject options = new JSONObject();
		options.put("razorpay_order_id", orderDetails.getRazorpay_order_id());
		options.put("razorpay_payment_id", orderDetails.getRazorpay_payment_id());
		options.put("razorpay_signature", orderDetails.getRazorpay_signature());
		if(Utils.verifyPaymentSignature(options, "6REjsUiIJAWvnQvIRf40BXA7")) {
			mandv.addObject("Status","Successfully Paid");
		}
		else {
			mandv.addObject("Status","Unsuccessfull Payment");
		}
		
		mandv.setViewName("verified");
		return mandv;
		
		
		
		
	}
	
	
}
