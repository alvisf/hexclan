package com.service;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.InvoiceMasterDAO;
import com.dao.InvoiceMasterDAOImpl;
import com.dao.ItemDetailsDAO;
import com.dao.ItemTransactionDAO;
import com.dao.ItemTransactionDAOImpl;
import com.dao.UserDetailsDAO;
import com.model.InvoiceMasterDTO;
import com.model.ItemDetailsDTO;
import com.model.ItemTransactionDTO;
import com.model.UserDetailsDTO;


@Service("invoiceService")
public class InvoiceServiceImpl implements InvoiceService,Cloneable{
	
	@Autowired
	private UserDetailsDAO userDetailsDAO;
	
	@Autowired
	private InvoiceMasterDAO invoiceMasterDAO;
	
	@Autowired
	private ItemTransactionDAO itemTransactionDAO;
	
	@Autowired
	private ItemDetailsDAO itemDetailsDAO;
	

//	public String getXML(int invNo,Double total) {
//		XMLServiceImpl xmlServiceImpl = XMLServiceImpl.getXMLServiceImpl();
//		return xmlServiceImpl.createXML(invNo, total);
//	}
	
	@Override
	@Transactional
	public void insertInvoices(String uname,HashMap<ItemDetailsDTO,Integer> items, HttpSession session) {
		UserDetailsDTO user = userDetailsDAO.getUserDTObyName(uname);
		
		
		InvoiceMasterDTO invoice = new InvoiceMasterDTO();
		invoice.setUserDetailsDTO(user);
		invoice.setInvDate(LocalDate.now());
		
		
		invoiceMasterDAO.insertInvoice(invoice);
		
	
		for(ItemDetailsDTO item:items.keySet()) {
			ItemTransactionDTO transac = new ItemTransactionDTO();
			
			transac.setInvoiceMasterDTO(invoice);

			int quantity = items.get(item);
			transac.setItemQuantity(quantity);
			
			
			int updatedQuantity = item.getStockQuantity() - quantity;
			item.setStockQuantity(updatedQuantity);
			
			
			itemDetailsDAO.updateItemDetails(item);
			
			transac.setItemDetailsDTO(item);
			itemTransactionDAO.insertItemTransaction(transac);
		}
		
		session.setAttribute("invNo", invoice.getInvNo());
	}
	
	@Override
	@Transactional
	public List<InvoiceMasterDTO> getAllInvoices(){
		List<InvoiceMasterDTO> invoices = invoiceMasterDAO.getInvoiceMasterAll();
		return invoices;
	}
		
//		invoice.setTransactions(transactions);
	
//	public int createInvoice(int invNo,int customerNo,List<Integer> itemList) {
//		
//		InvoiceMasterDAO invoiceMasterDAOImpl = InvoiceMasterDAOImpl.getInvoiceMasterDAOImpl();
//		InvoiceMasterDTO invoiceMasterDTO = InvoiceMasterDTO.getInvoiceMasterDTO();
//		
//		
//		Date date = LocalDate.now();
//		
//		invoiceMasterDTO.setInvNo(invNo);
//		invoiceMasterDTO.setInvDate(date);
//		invoiceMasterDTO.setCustomerno(customerNo);
//		int result = invoiceMasterDAOImpl.insertInvoice(invoiceMasterDTO);
//		
//		ItemTransactionDAO itemTransactionDAOImpl = ItemTransactionDAOImpl.getItemTransactionDAOImpl();
//		
//		
//		for(int itemNo:itemList) {
//			ItemTransactionDTO itemTransactionDTO = ItemTransactionDTO.getItemTransactionDTO();
//			itemTransactionDTO.setItemQuantity(1);
//			itemTransactionDTO.setInvNo(invNo);
//			itemTransactionDTO.setItemNo(itemNo);
//			
//			itemTransactionDAOImpl.insertItemTransaction(itemTransactionDTO);
//		}
//		return result;
//	}
	
//	@Override
//	public int getInvNo() {
//		InvoiceMasterDAO invoiceMasterDAOImpl = InvoiceMasterDAOImpl.getInvoiceMasterDAOImpl();
//		int invNo = invoiceMasterDAOImpl.getLength()+1;
//		return invNo;
//	}

	public final InvoiceMasterDAO getInvoiceMasterDAO() {
		return invoiceMasterDAO;
	}

	public final void setInvoiceMasterDAO(InvoiceMasterDAO invoiceMasterDAO) {
		this.invoiceMasterDAO = invoiceMasterDAO;
	}

	public final ItemTransactionDAO getItemTransactionDAO() {
		return itemTransactionDAO;
	}

	public final void setItemTransactionDAO(ItemTransactionDAO itemTransactionDAO) {
		this.itemTransactionDAO = itemTransactionDAO;
	}

	public final UserDetailsDAO getUserDetailsDAO() {
		return userDetailsDAO;
	}

	public final void setUserDetailsDAO(UserDetailsDAO userDetailsDAO) {
		this.userDetailsDAO = userDetailsDAO;
	}

	public final ItemDetailsDAO getItemDetailsDAO() {
		return itemDetailsDAO;
	}

	public final void setItemDetailsDAO(ItemDetailsDAO itemDetailsDAO) {
		this.itemDetailsDAO = itemDetailsDAO;
	}
	
	
}
