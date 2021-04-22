package com.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.ItemDetailsDTO;
import com.model.UserDetailsDTO;
import com.service.ShoppingService;



@Controller
@RequestMapping("shopping")
public class ShoppingController {
	
	@Autowired
	private ShoppingService shoppingService;
	
	public ShoppingController() {
		
	}

	public final ShoppingService getShoppingService() {
		return shoppingService;
	}

	public final void setShoppingService(ShoppingService shoppingService) {
		this.shoppingService = shoppingService;
	}

	@RequestMapping(value="shopping1", method=RequestMethod.GET)
	public ModelAndView loadShoppingForm1(UserDetailsDTO user, ModelAndView mandv,Model model) { 
		
		//getModel1(model);
		List<ItemDetailsDTO> items = shoppingService.dispallitems("grocery");
		model.addAttribute("items",items);
		mandv.setViewName("groceryshop");
		return mandv;
	}
	
	@RequestMapping(value="shopping2", method=RequestMethod.GET)
	public ModelAndView loadShoppingForm2(UserDetailsDTO user, ModelAndView mandv,Model model) { 
		
		//getModel2(model);
		List<ItemDetailsDTO> items = shoppingService.dispallitems("clothing");
		model.addAttribute("items",items);
		mandv.setViewName("clothingshop");
		return mandv;
	}
	
	@RequestMapping(value="shopping3", method=RequestMethod.GET)
	public ModelAndView loadShoppingForm3(UserDetailsDTO user, ModelAndView mandv,Model model) { 
		
		//getModel3(model);
		List<ItemDetailsDTO> items = shoppingService.dispallitems("jewellery");
		model.addAttribute("items",items);
		mandv.setViewName("jewelleryshop");
		return mandv;
	}
	
	@RequestMapping(value="submitShoppingForm1", method=RequestMethod.POST)
	public ModelAndView submitCheckBoxForm1(ModelAndView mandv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		String[] selected=request.getParameterValues("selected");
		HashMap<Integer,Integer> selecteditems = (HashMap<Integer,Integer>)session.getAttribute("selecteditems");
		for(int i=0;i<selected.length;i++) {
			String qty=request.getParameter(selected[i]);
			selecteditems.put(Integer.parseInt(selected[i]),Integer.parseInt(qty));
			
		}
		
		session.setAttribute("selecteditems", selecteditems);
		mandv.setViewName("redirect:/shopping/shopping1");
		return mandv;
	}	
	
	@RequestMapping(value="submitShoppingForm2", method=RequestMethod.POST)
	public ModelAndView submitCheckBoxForm2(ModelAndView mandv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		String[] selected=request.getParameterValues("selected");
		HashMap<Integer,Integer> selecteditems = (HashMap<Integer,Integer>)session.getAttribute("selecteditems");
		for(int i=0;i<selected.length;i++) {
			String qty=request.getParameter(selected[i]);
			selecteditems.put(Integer.parseInt(selected[i]),Integer.parseInt(qty));
			
		}
		
		session.setAttribute("selecteditems", selecteditems);
		mandv.setViewName("redirect:/shopping/shopping2");
		return mandv;
	}
	
	@RequestMapping(value="submitShoppingForm3", method=RequestMethod.POST)
	public ModelAndView submitCheckBoxForm3(ModelAndView mandv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		String[] selected=request.getParameterValues("selected");
		HashMap<Integer,Integer> selecteditems = (HashMap<Integer,Integer>)session.getAttribute("selecteditems");
		for(int i=0;i<selected.length;i++) {
			String qty=request.getParameter(selected[i]);
			selecteditems.put(Integer.parseInt(selected[i]),Integer.parseInt(qty));
			
		}
		
		session.setAttribute("selecteditems", selecteditems);
		mandv.setViewName("redirect:/shopping/shopping3");
		return mandv;
	}
	
	@RequestMapping(value="cart", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView showCart(ModelAndView mandv){
		mandv.setViewName("redirect:/cart/showCart");
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
	

}
