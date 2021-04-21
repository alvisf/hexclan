package com.controller;

import java.lang.ProcessBuilder.Redirect;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.model.ItemDetailsDTO;
import com.model.UserDetailsDTO;
import com.service.ShoppingService;
import com.service.UserService;

@Controller
@RequestMapping("login")
@SessionAttributes({"user","uid"})

public class LoginController {
	
	@Autowired
	private UserService userService;
	
	public final UserService getUserService() {
		return userService;
	}

	public final void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Autowired
	private ShoppingService shoppingService;
		
	public final ShoppingService getShoppingService() {
		return shoppingService;
	}

	public final void setShoppingService(ShoppingService shoppingService) {
		this.shoppingService = shoppingService;
	}

	@RequestMapping(value="loadForm", method=RequestMethod.GET)
	public ModelAndView loadLoginForm(ModelAndView mandv,Model model) {
		UserDetailsDTO user=new UserDetailsDTO();
		model.addAttribute("user",user);
		mandv.setViewName("login");
		return mandv;
	}
	
	@RequestMapping(value="submitForm", method=RequestMethod.POST)
	public ModelAndView submitLoginForm(UserDetailsDTO user,ModelAndView mandv,HttpServletRequest request,Model model) {
		if(userService.checkUser(user.getUname(),user.getUpass())){
			if(userService.checkLogin(user.getUname())) {
				user = userService.getUser(user.getUname());
				String role=user.getRole();
				int uid=user.getUid();
				user.setUid(uid);
				HttpSession session = request.getSession();
				session.setAttribute("uname", user.getUname());
				session.setAttribute("uid", uid);
				
				HashMap<Integer,Integer> selecteditems=new HashMap<Integer, Integer>();
				session.setAttribute("selecteditems", selecteditems);
				
				mandv.addObject("user",user);
			
				
				switch(role) {
				case "admin":
				List<ItemDetailsDTO> items=shoppingService.allItems();
					mandv.addObject("user",user);
					mandv.addObject("items",items);
					mandv.setViewName("adminpage");
					return mandv;
					
				case "manager":
				
					List<ItemDetailsDTO> itemss=shoppingService.allItems();
					System.out.println(itemss);
					mandv.addObject("user",user);
					mandv.addObject("items",itemss);
					mandv.setViewName("managerhome");
					return mandv;
					
				case "customer":
					
					
					mandv.addObject("user",user);
					
					mandv.setViewName("welcome");
					return mandv;
				default:
					return null;
				}
			}
			else {
				mandv.setViewName("already");
				return mandv;
			}
		}
		else {
			mandv.setViewName("redirect:/register/loadForm");
			return mandv;
		}
		}
	
	@RequestMapping(value="gotoregForm", method=RequestMethod.GET)
	public String goToReg(ModelAndView mandv) {
		return "redirect:/register/loadForm";
	}
	
	/* @RequestMapping(value="logout", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView logout(ModelAndView mandv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		String uname = (String)session.getAttribute("uname");
		loginService.updateFlag(uname, 0);
		//session.invalidate();
		mandv.setViewName("redirect:/login/loadForm");
		return mandv;
	}
	*/
	
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
	
	@RequestMapping(value="home", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView home(ModelAndView mandv,HttpServletRequest request) {
		mandv.setViewName("welcome");
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
	
	
	@RequestMapping(value="confirmorder", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView confirmOrder(ModelAndView mandv,HttpServletRequest request) {
		mandv.setViewName("redirect:/invoice/payment");
		return mandv;
	}
	
	
	@RequestMapping(value="remove", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView remove(ModelAndView mandv,HttpServletRequest request) {
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
		mandv.setViewName("invoice"); 
		return mandv; 

	}
	
}
