package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.model.ItemDetailsDTO;
import com.service.AdminService;
import com.service.ShoppingService;

@Controller
@RequestMapping("itemcontrol")
@SessionAttributes("admin")
public class ItemController {
	
	@Autowired
	private ShoppingService shoppingService;
		
	public final ShoppingService getShoppingService() {
		return shoppingService;
	}

	public final void setShoppingService(ShoppingService shoppingService) {
		this.shoppingService = shoppingService;
	}
	@Autowired
	private AdminService adminService;
	

	@RequestMapping(value="shop1", method=RequestMethod.GET)
	public ModelAndView loadshop1(ModelAndView mandv) {
		List<ItemDetailsDTO> items=shoppingService.dispallitems("jewellery");
		mandv.addObject("items",items);
		
		mandv.setViewName("adminshop");
		return mandv;
	}
	@RequestMapping(value="shop2", method=RequestMethod.GET)
	public ModelAndView loadshop2(ModelAndView mandv) {
		List<ItemDetailsDTO> items=shoppingService.dispallitems("grocery");
		mandv.addObject("items",items);
		
		mandv.setViewName("adminshop");
		return mandv;
	}
	@RequestMapping(value="shop3", method=RequestMethod.GET)
	public ModelAndView loadshop3(ModelAndView mandv) {
		List<ItemDetailsDTO> items=shoppingService.dispallitems("sports");
		mandv.addObject("items",items);
		
		mandv.setViewName("adminshop");
		return mandv;
	}
	@RequestMapping(value="add", method=RequestMethod.POST)
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
		
		System.out.println(id);
		
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
	
	
}

