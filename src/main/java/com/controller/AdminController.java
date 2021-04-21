/*

package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.model.Admin;

import com.service.AdminService;

@Controller
@RequestMapping("adminlogin")
@SessionAttributes("admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="loadadminForm", method=RequestMethod.GET)
	public ModelAndView loadLoginForm(ModelAndView mandv,Model mod) {
		
		
		mod.addAttribute("admin",new Admin());
		mandv.setViewName("adminlogin");
		return mandv;
	}
	
	@RequestMapping(value="submitadminForm", method=RequestMethod.POST)
	public ModelAndView submitLoginForm(Admin admin,ModelAndView mandv,HttpServletRequest request) {
		if(adminService.checkLogin(admin.getUname(), admin.getUpass())) {
	
			
				
				
				
				System.out.println("called");
				mandv.addObject("admin",admin);
				
				mandv.setViewName("welcomeadmin");
				return mandv;
				
						
			
		}
		else {
			mandv.setViewName("error");
			return mandv;
		}
	}
	
	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
}
*/