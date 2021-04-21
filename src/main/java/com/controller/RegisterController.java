package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.UserDetailsDTO;

import com.service.UserService;

@Controller
@RequestMapping("register")
public class RegisterController {
	public RegisterController() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private UserService userService;
	
	public final UserService getUserService() {
		return userService;
	}
	public final void setUserService(UserService userService) {
		this.userService = userService;
	}
	@RequestMapping(value="loadForm", method=RequestMethod.GET)
	public ModelAndView loadRegisterForm(ModelAndView mandv,Model model) {
		UserDetailsDTO user=new UserDetailsDTO();
		model.addAttribute("user",user);
		mandv.setViewName("register");
		return mandv;
	}
	@RequestMapping(value="submitForm", method=RequestMethod.POST)
	public ModelAndView submitRegisterForm(UserDetailsDTO user,ModelAndView mandv,Model model) {
		if(userService.checkUser(user.getUname(),user.getUpass())){
			mandv.addObject("user",user);
			mandv.setViewName("login");
			return mandv;
		}else {
			userService.createUser(user);
			mandv.setViewName("login");
			return new ModelAndView("redirect:/login/loadForm");
		}
	
	}
	@RequestMapping(value="tologin", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView toRegister(UserDetailsDTO user,ModelAndView mandv,HttpServletRequest request) {
		mandv.setViewName("redirect:/login/loadForm");
		return mandv;
	}
	
	
}
