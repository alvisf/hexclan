package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ReportDao;
import com.model.ItemTransactionDTO;
import com.service.ManagerService;

@Controller
@RequestMapping("hello")
public class HelloController {
	
	@Autowired
	private ManagerService managerService;
	
	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	@RequestMapping("hello1")
	public void hello2(ModelAndView mandv) {
		
		managerService.getReportByInvno(1);
		
		
		
	}



}
