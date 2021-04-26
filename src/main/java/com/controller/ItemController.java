package com.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.model.InvoiceMasterDTO;
import com.model.ItemDetailsDTO;
import com.model.ItemTransactionDTO;
import com.model.UserDetailsDTO;
import com.service.AdminService;
import com.service.ManagerService;
import com.service.ShoppingService;

@Controller
@RequestMapping("itemcontrol")
@SessionAttributes("admin")
public class ItemController {
	
	@Autowired
	private ShoppingService shoppingService;
	
	@Autowired
	private ManagerService managerService;
		
	public final ShoppingService getShoppingService() {
		return shoppingService;
	}

	public final void setShoppingService(ShoppingService shoppingService) {
		this.shoppingService = shoppingService;
	}
	@Autowired
	private AdminService adminService;
	
	 @RequestMapping(value="home", method= {RequestMethod.GET,RequestMethod.POST})
		public ModelAndView home(ModelAndView mandv,HttpServletRequest request) {
		 	mandv.setViewName("redirect:/itemcontrol/modifyitem");
		 	return mandv;
		 	
	 	}
	
	@RequestMapping(value="add", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView loadshopadd(ModelAndView mandv,Model model) {
		ItemDetailsDTO item=new ItemDetailsDTO();
		model.addAttribute("item",item);
		mandv.setViewName("additem");
		return mandv;
	}
	@RequestMapping(value="submitadd", method=RequestMethod.POST)
	public ModelAndView submitshop1add(ItemDetailsDTO item, ModelAndView mandv,HttpServletRequest req ) {
		
		adminService.addItem(item);
		List<ItemDetailsDTO> items=shoppingService.allItems();
		mandv.addObject("items",items);
		mandv.setViewName("adminpage");
		return mandv;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
@RequestMapping(value="editdelete", method=RequestMethod.GET)
	public ModelAndView loadshop1editdelete(ModelAndView mandv,HttpServletRequest req) {

		List<ItemDetailsDTO> items=shoppingService.allItems();
		mandv.addObject("items",items);
		
		mandv.setViewName("adminshop");
		return mandv;
	}
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public ModelAndView loadshopdelete(ModelAndView mandv,HttpServletRequest req ) {
		String id=req.getParameter("selected");
		
		System.out.println(id);
		ItemDetailsDTO item=shoppingService.getItemById(Integer.parseInt(id));
		
		mandv.addObject("items",item);
		
		mandv.setViewName("editform");
		
		return mandv;
	}
	@RequestMapping(value="deleteditem", method=RequestMethod.POST)
	public ModelAndView submitshopdelete(ModelAndView mandv,HttpServletRequest req ) {
		String id=req.getParameter("selected");
		
		adminService.deleteItem(Integer.parseInt(id));
		List<ItemDetailsDTO> items=shoppingService.allItems();
		mandv.addObject("items",items);
		mandv.setViewName("adminpage");
		
		return mandv;
	}
	@RequestMapping(value="edit", method=RequestMethod.POST)
	public ModelAndView loadshopedit(ModelAndView mandv,HttpServletRequest req,Model model ) {
		String id=req.getParameter("selected");
		System.out.println(id);
		ItemDetailsDTO itemmodel=new ItemDetailsDTO();
		model.addAttribute("itemmodel",itemmodel);
		ItemDetailsDTO item=shoppingService.getItemById(Integer.parseInt(id));
		System.out.println(item.getItemDesc());
		mandv.addObject("item",item);
		mandv.setViewName("edititem");
		
		return mandv;
	}
	@RequestMapping(value="edittedditem", method=RequestMethod.POST)
	public ModelAndView submitshopedit(ModelAndView mandv,HttpServletRequest req,ItemDetailsDTO items ) {		
		
		adminService.editItem(items);
		
		List<ItemDetailsDTO> itemss=shoppingService.allItems();
		mandv.addObject("items",itemss);
		mandv.setViewName("adminpage");
		return mandv;
	}
	
	@RequestMapping(value="logout", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView logout(ModelAndView mandv,HttpServletRequest request) {
		mandv.setViewName("redirect:/login/logout");
		return mandv;
	}
	
	@RequestMapping(value="modifyitem", method=RequestMethod.GET)
	public ModelAndView modifyitem(ModelAndView mandv,Model model) {
		List<ItemDetailsDTO> items=shoppingService.allItems();
		mandv.addObject("items",items);
		mandv.setViewName("adminpage");
		return mandv;
	}
	@RequestMapping(value="modifybillitem", method=RequestMethod.POST)
	public ModelAndView modifybillitem(ModelAndView mandv,Model model,HttpServletRequest req) {
		String id=req.getParameter("id");
		System.out.println(id);
		String qty=req.getParameter(id);
		System.out.println(qty);
		adminService.updateqty(Integer.parseInt(id), Integer.parseInt(qty));
		mandv.setViewName("modifybill");
		return mandv;
	}
	@RequestMapping(value="modifiedbillitem", method=RequestMethod.GET)
	public ModelAndView modifiedbillitem(ModelAndView mandv,Model model) {
		List<ItemDetailsDTO> items=shoppingService.allItems();
		mandv.addObject("items",items);
		mandv.setViewName("adminpage");
		return mandv;
	}
	@RequestMapping(value="deletebilltem", method=RequestMethod.POST)
	public ModelAndView deletebillitem(ModelAndView mandv,Model model,HttpServletRequest req) {
		String id=req.getParameter("id");
		System.out.println(id);
		adminService.deleteTransaction(Integer.parseInt(id));
		
		mandv.setViewName("modifybill");
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
		mandv.setViewName("modifybill");
		return mandv;
	}
	@RequestMapping(value="modifybill", method=RequestMethod.GET)
	public ModelAndView modifybill(ModelAndView mandv,Model model) {
		mandv.setViewName("modifybill");
		return mandv;	
	}
	
	
}

