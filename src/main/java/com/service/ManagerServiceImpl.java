package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ReportDao;
import com.dao.UserDAO;
import com.model.InvoiceMasterDTO;
import com.model.ItemDetailsDTO;
import com.model.ItemTransactionDTO;
import com.model.UserDetailsDTO;

@Service("managerService")
public class ManagerServiceImpl implements ManagerService{
	
	@Autowired
	private ReportDao reportDao;
	@Autowired
	private UserDAO userDao;
	
public UserDAO getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
@Override
@Transactional
public List<ItemTransactionDTO> getReportByInvno(int invno) {
	InvoiceMasterDTO invoice=reportDao.getInvoicMasterByInvoice(invno);
	List<ItemTransactionDTO> trans= reportDao.getItemTransactionByInvoice(invoice);
	ListIterator iterator2 = trans.listIterator();
	//ItemTransactionDTO itemtrans=new ItemTransactionDTO();
	//ItemDetailsDTO items=new ItemDetailsDTO();
		while(iterator2.hasNext()) {
		ItemTransactionDTO itemtrans=(ItemTransactionDTO)iterator2.next();
		ItemDetailsDTO items=itemtrans.getItemDetailsDTO();
		System.out.println(items);
		System.out.println("Name of product"+" "+ items.getItemDesc());
		System.out.println("Price of product"+" "+ items.getItemPrice());
		invoice=itemtrans.getInvoiceMasterDTO();
		System.out.println("Date"+" "+ invoice.getInvDate());
		
		}
		return trans;
}
@Override
@Transactional
	public List<ItemDetailsDTO> getReportByDate(int invno) {
		// TODO Auto-generated method stub
		return null;
	}
@Override
@Transactional
	public List<ItemTransactionDTO> getReportByCustomerID(int custid) {
	UserDetailsDTO user=userDao.getUserById(custid);
	List<InvoiceMasterDTO> inv= reportDao.getInvoiceByUser(user);
	List<ItemTransactionDTO> it=new ArrayList<>();
	List<ItemTransactionDTO> trans=new ArrayList<>();
	
	trans=reportDao.getByList(inv);
	
	return trans;
	
	
		
}
@Override
@Transactional
public List<ItemTransactionDTO> getAllReports() {
	
	List<ItemTransactionDTO>items=reportDao.getAllTransaction();
	
	return items;
	
	
}
@Override
@Transactional
	public void test(int custid) {

	}
public ReportDao getReportDao() {
	return reportDao;
}
public void setReportDao(ReportDao reportDao) {
	this.reportDao = reportDao;
}
}
