package com.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.InvoiceMasterDTO;
import com.model.ItemDetailsDTO;
import com.model.ItemTransactionDTO;
import com.model.UserDetailsDTO;
import com.service.ManagerService;
import com.service.ShoppingService;

@Controller
@RequestMapping("manage")
public class ManagerController {
	@Autowired
	private ManagerService managerService;
	
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
		
		/*
		List<ItemTransactionDTO> itemtrancs=managerService.getAllReports();
		List<ItemDetailsDTO> itemlist=new ArrayList<>();
		List<InvoiceMasterDTO> invoicelist=new ArrayList<>();
		ListIterator iterator2 = itemtrancs.listIterator();
		ItemTransactionDTO singletrans=new ItemTransactionDTO();
		ItemDetailsDTO singleitem=new ItemDetailsDTO();
		InvoiceMasterDTO singleinvoice=new InvoiceMasterDTO();
			while(iterator2.hasNext()) {
			singletrans=(ItemTransactionDTO)iterator2.next();
			singleinvoice= singletrans.getInvoiceMasterDTO();
			singleitem=singletrans.getItemDetailsDTO();
			invoicelist.add(singleinvoice);
			itemlist.add(singleitem);
			


			}

		mandv.addObject("itemtrancs",itemtrancs);
		mandv.addObject("invoices",invoicelist);
		mandv.addObject("items",itemlist);
		mandv.setViewName("invoicesearch");
		return mandv;	
		*/
		
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
		
		/*
		List<ItemTransactionDTO> itemtrancs=managerService.getAllReports();
		List<ItemDetailsDTO> itemlist=new ArrayList<>();
		List<InvoiceMasterDTO> invoicelist=new ArrayList<>();
		ListIterator iterator2 = itemtrancs.listIterator();
		ItemTransactionDTO singletrans=new ItemTransactionDTO();
		ItemDetailsDTO singleitem=new ItemDetailsDTO();
		InvoiceMasterDTO singleinvoice=new InvoiceMasterDTO();
			while(iterator2.hasNext()) {
			singletrans=(ItemTransactionDTO)iterator2.next();
			singleinvoice= singletrans.getInvoiceMasterDTO();
			singleitem=singletrans.getItemDetailsDTO();
			invoicelist.add(singleinvoice);
			itemlist.add(singleitem);
			


			}

		mandv.addObject("itemtrancs",itemtrancs);
		mandv.addObject("invoices",invoicelist);
		mandv.addObject("items",itemlist);
		mandv.setViewName("invoicesearch");
		return mandv;	
		*/
		
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
	
	
	public ShoppingService getShoppingService() {
		return shoppingService;
	}

	public void setShoppingService(ShoppingService shoppingService) {
		this.shoppingService = shoppingService;
	}
}
