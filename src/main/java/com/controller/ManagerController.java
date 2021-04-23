package com.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.InvoiceMasterDTO;
import com.model.ItemDetailsDTO;
import com.model.ItemTransactionDTO;
import com.model.UserDetailsDTO;
import com.service.InvoiceService;
import com.service.ManagerService;
import com.service.ShoppingService;

@Controller
@RequestMapping("manage")
public class ManagerController {
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private InvoiceService invoiceService;
	
	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	@Autowired
	private ShoppingService shoppingService;

	@RequestMapping("submititemForm")
	public ModelAndView manageiditem(ModelAndView mandv,HttpServletRequest req) {
		
		String id=req.getParameter("id");
		System.out.println(id);
		ItemDetailsDTO singleitem=shoppingService.getItemById(Integer.parseInt(id));
		List<ItemDetailsDTO> item=new ArrayList<ItemDetailsDTO>();
		item.add(singleitem);
		mandv.addObject("items",item);
		mandv.setViewName("inventory");
		return mandv;	
	}
	@RequestMapping("submitallForm")
	public ModelAndView manageall(ModelAndView mandv,HttpServletRequest req) {
		
		List<ItemDetailsDTO>item=shoppingService.allItems();
		mandv.addObject("items",item);
		mandv.setViewName("inventory");
		return mandv;	
	}
	@RequestMapping("customerquery")
	public ModelAndView customerquery(ModelAndView mandv,HttpServletRequest req) {
		
		mandv.setViewName("customerinvoice");
		return mandv;	
	}
	@RequestMapping("invoicequery")
	public ModelAndView invoicequery(ModelAndView mandv,HttpServletRequest req) {
		
		mandv.setViewName("invoicesearch");
		return mandv;	
	}
	@RequestMapping("home")
	public ModelAndView home(ModelAndView mandv,HttpServletRequest req) {
		
		mandv.setViewName("managerhome");
		return mandv;	
	}
	@RequestMapping("getcustomer")
	public ModelAndView showcustomer(ModelAndView mandv,HttpServletRequest req) {
		
		String id=req.getParameter("id");
		
		List<ItemTransactionDTO> translist=managerService.getReportByCustomerID(Integer.parseInt(id));
		
		List<ItemDetailsDTO> itemlist=new ArrayList<>();
		List<InvoiceMasterDTO> invoicelist=new ArrayList<>();
		
		ListIterator iterator2 = translist.listIterator();
		int custid=0;
		LocalDate date=LocalDate.of(2016, 9, 23);
		while(iterator2.hasNext()) {
		
			ItemTransactionDTO itr=(ItemTransactionDTO)iterator2.next();
			
			InvoiceMasterDTO inv=itr.getInvoiceMasterDTO();
			
			date=inv.getInvDate();
			UserDetailsDTO user=inv.getUserDetailsDTO();
			
			custid=user.getUid();
			
			
		}

		mandv.addObject("custid",custid);
		mandv.addObject("itemtrancs",translist);
	
		
		mandv.setViewName("customerinvoice");
		return mandv;
	}
	@RequestMapping("getinvoice")
	public ModelAndView showinvoice(ModelAndView mandv,HttpServletRequest req) {
		
		String id=req.getParameter("id");
		
		List<ItemTransactionDTO>translist=managerService.getReportByInvno(Integer.parseInt(id));
		
		List<ItemDetailsDTO> itemlist=new ArrayList<>();
		List<InvoiceMasterDTO> invoicelist=new ArrayList<>();
		
		ListIterator iterator2 = translist.listIterator();
		int custid=0;
		LocalDate date=LocalDate.of(2016, 9, 23);
		while(iterator2.hasNext()) {
		
			ItemTransactionDTO itr=(ItemTransactionDTO)iterator2.next();
			
			InvoiceMasterDTO inv=itr.getInvoiceMasterDTO();
			
			date=inv.getInvDate();
			UserDetailsDTO user=inv.getUserDetailsDTO();
			
			custid=user.getUid();
			
			
		}
		mandv.addObject("date",date);
		mandv.addObject("invid",id);
		mandv.addObject("custid",custid);
		mandv.addObject("itemtrancs",translist);
		mandv.setViewName("invoicesearch");
		return mandv;
	}
	
	@RequestMapping("dateinvoice")
	public ModelAndView date(ModelAndView mandv,HttpServletRequest req) {
		
		mandv.setViewName("date");
		return mandv;
	}
	
	@RequestMapping("getdateinvoice")
	public ModelAndView getdateinvoice(ModelAndView mandv,HttpServletRequest req) {
		
		String fromdate  = req.getParameter("startdate");
		String todate  = req.getParameter("enddate");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate startLdate = LocalDate.parse(fromdate, formatter);
		LocalDate endLdate = LocalDate.parse(todate, formatter);
		
		
		
		List<InvoiceMasterDTO> invoices = invoiceService.getAllInvoices();
		
		List<ItemTransactionDTO> rangetransset = new ArrayList<ItemTransactionDTO>(); 
		
		for(InvoiceMasterDTO invoice : invoices) {
			LocalDate invoicedate = invoice.getInvDate();
			if(invoicedate.isAfter(startLdate) && invoicedate.isBefore(endLdate)) {
				
				for(ItemTransactionDTO transaction : invoice.getTransactions()) {
					rangetransset.add(transaction);
				}
			}
		}
		
		System.out.println(rangetransset);
		mandv.addObject("rangetransset",rangetransset);
		
		mandv.setViewName("date");
		return mandv;
	}
	
	@RequestMapping(value="logout", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView logout(ModelAndView mandv,HttpServletRequest request) {
		mandv.setViewName("redirect:/login/logout");
		return mandv;
	}
	
	
	public ShoppingService getShoppingService() {
		return shoppingService;
	}

	public void setShoppingService(ShoppingService shoppingService) {
		this.shoppingService = shoppingService;
	}
}
