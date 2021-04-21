package com.controller;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.model.ItemDetailsDTO;
import com.model.OrderDetails;
import com.model.SmsPojo;
import com.model.UserDetailsDTO;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.service.EmailService;
import com.service.EmailServiceImpl;
import com.service.InvoiceService;
import com.service.ShoppingService;
import com.service.SmsService;
import com.service.UserService;
import com.service.XMLService;
import com.service.XMLToExcelService;
import com.service.XMLToExcelServiceImpl;
import com.service.XMLToPdfService;

@Controller
@RequestMapping("invoice")
public class InvoiceController {
	@Autowired
	InvoiceService invoiceService;
	
	@Autowired
	private ShoppingService shoppingService;
	
	public XMLService getXmlService() {
		return xmlService;
	}

	public void setXmlService(XMLService xmlService) {
		this.xmlService = xmlService;
	}

	public EmailService getEmailService() {
		return emailService;
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public XMLToExcelService getExcelService() {
		return excelService;
	}

	public void setExcelService(XMLToExcelService excelService) {
		this.excelService = excelService;
	}

	public XMLToPdfService getPdfService() {
		return pdfService;
	}

	public void setPdfService(XMLToPdfService pdfService) {
		this.pdfService = pdfService;
	}

	public SmsService getSmsService() {
		return smsService;
	}

	public void setSmsService(SmsService smsService) {
		this.smsService = smsService;
	}
	
	@Autowired
	XMLService xmlService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	XMLToExcelService excelService;
	
	@Autowired
	XMLToPdfService pdfService;
	
	@Autowired
	SmsService smsService;
	
//	@RequestMapping(value="payment", method=RequestMethod.GET)
//	public ModelAndView test(ModelAndView mandv,Model model) throws RazorpayException {
//	OrderDetails orderDetails = new OrderDetails();
//	model.addAttribute("orderDetails", orderDetails);
//		System.out.println("home called");
//		mandv.addObject("msg","df");
//		mandv.setViewName("payment");
//		return mandv;
//		
//	}
	
	@RequestMapping(value="payment", method=RequestMethod.GET)
	public ModelAndView payment(ModelAndView mandv,HttpServletRequest request,Model model) {
		
		mandv.setViewName("payment");
		return mandv;
	}
	
//	@PostMapping(value="order")
//	public ModelAndView createOrder(@ModelAttribute("amount") OrderDetails orderDetails,ModelAndView mandv) throws RazorpayException {
//		
//		RazorpayClient razorpayClient = new RazorpayClient("rzp_test_uwFPahVNP7SemQ", "6REjsUiIJAWvnQvIRf40BXA7");
//		JSONObject options = new JSONObject();
////		OrderDetails order_info = new OrderDetails();
//
//		System.out.println(orderDetails);
//		int amount=Integer.parseInt(orderDetails.getAmount());
//		System.out.println(amount);
//		options.put("amount",amount);
//		options.put("currency", "INR");
//		options.put("receipt", "txn_123456");
//		Order order = razorpayClient.Orders.create(options);
//		System.out.println(order);
//		
//		mandv.addObject("amt",amount);
//		mandv.addObject("order_id",order.get("id"));
//		mandv.setViewName("paid");
//		return mandv;
//		
//
//		
//	}
//	
	@RequestMapping(value="paymentSuccess", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView paymentSuccess(ModelAndView mandv,HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
		String uname = (String)session.getAttribute("uname");

		UserDetailsDTO user = userService.getUser(uname);
		HashMap<ItemDetailsDTO,Integer> items = (HashMap<ItemDetailsDTO,Integer>)session.getAttribute("items"); 
		
		invoiceService.insertInvoices(uname,items,session);

		int invNo = (int)session.getAttribute("invNo");
		Double total = (Double)session.getAttribute("total");
		
		String xmlFilePath = xmlService.createXML(invNo, total);
		
		session.setAttribute("xml", xmlFilePath);
		
		mandv.setViewName("thankyou");
		return mandv;
	}
	
	@RequestMapping(value="email", method=RequestMethod.GET)
	public ModelAndView generateemail(ModelAndView mandv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		String xml = (String)session.getAttribute("xml");
		try {
			String userName = (String)session.getAttribute("uname");
			UserDetailsDTO user = userService.getUser(userName);
			String uemail = user.getUserEmail();
			
			emailService.sendMail(uemail,xml);
			mandv.setViewName("thankyou");
			return mandv;
			
		}catch(Exception e) {e.printStackTrace();return null;}
	}
	
	@RequestMapping(value="excel", method=RequestMethod.GET)
	public ModelAndView generateexcel(ModelAndView mandv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		String xml = (String)session.getAttribute("xml");
		try {
			excelService.writeData(xml);
			mandv.setViewName("thankyou");
			return mandv;
			
		}catch(Exception e) {e.printStackTrace();return null;}
	}
	
	@RequestMapping(value="pdf", method=RequestMethod.GET)
	public ModelAndView generatepdf(ModelAndView mandv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		String xml = (String)session.getAttribute("xml");
		try {
			pdfService.convert(xml);
			mandv.setViewName("thankyou");
			return mandv;
			
		}catch(Exception e) {e.printStackTrace();return null;}
	}
	
	@RequestMapping(value="sms", method=RequestMethod.GET)
	public ModelAndView generatesms(ModelAndView mandv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		//String xml = (String)session.getAttribute("xml");
		
		String userName = (String)session.getAttribute("uname");
		UserDetailsDTO user = userService.getUser(userName);
		long phone = user.getUserPhone();
		
		Double total = (Double)session.getAttribute("total");
		
		HttpClient httpClient = HttpClientBuilder.create().build();
		try {
			System.out.println("+++++++++++++++++");
			System.out.println("+++++++++++++++++");
		    HttpPost req = new HttpPost("http://localhost:8080/sms");
		    
		    StringEntity params = new StringEntity("{\"to\":\"+91"+phone+"\",\"message\":\"Your invoice total is "+total+" rs\"}");
		    req.addHeader("content-type", "application/json");
		    req.setEntity(params);
		    HttpResponse response = httpClient.execute(req);
		    mandv.setViewName("thankyou");
			return mandv;
		}catch(Exception e) {e.printStackTrace();return null;}
	}
	
	@RequestMapping(value="logout", method=RequestMethod.POST)
	public ModelAndView logout(ModelAndView mandv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		mandv.setViewName("redirect:/login/logout");
		return mandv;
	}
	
	@RequestMapping(value="cart", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView showCart(ModelAndView mandv,HttpServletRequest request){
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
		return mandv; 
	}

	public final InvoiceService getInvoiceService() {
		return invoiceService;
	}

	public final void setInvoiceService(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	
}
