package com.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.InvoiceMasterDAO;
import com.dao.ItemDAO;
import com.dao.ItemDetailsDAO;
import com.dao.ItemTransactionDAO;
import com.dao.ReportDao;
import com.dao.UserDAO;
import com.model.InvoiceMasterDTO;
import com.model.ItemDetailsDTO;
import com.model.ItemTransactionDTO;




@Service("adminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private ItemDAO itemDao;
	
	@Autowired
	private ReportDao reportDao;
	
	@Autowired
	private ItemTransactionDAO invoiceDao;
	
	@Autowired
	private ItemTransactionDAO itemtransacdao;
	

@Override
@Transactional
public void addItem(ItemDetailsDTO item) {
	itemDao.createItem(item);
}
@Override
@Transactional
public void editItem(ItemDetailsDTO item) {
	itemDao.updateitem(item);
	
}
public ItemDAO getItemDao() {
	return itemDao;
}
public void setItemDao(ItemDAO itemDao) {
	this.itemDao = itemDao;
}
@Override
@Transactional
public void deleteItem(int uid) {
	ItemDetailsDTO item = itemDao.getItemById(uid);
	Set<ItemTransactionDTO> transacs = item.getTransactions();
	item.setTransactions(null);
	for(ItemTransactionDTO transac:transacs) {
		transac.setItemDetailsDTO(null);
	}
	itemDao.deleteitem(uid);
	
}
@Override
@Transactional
public void deleteTransaction(int transacno) {
	ItemTransactionDTO transac = itemtransacdao.getItemTransaction(transacno);
	InvoiceMasterDTO invoice = transac.getInvoiceMasterDTO();
	Set<ItemTransactionDTO> transacs = invoice.getTransactions();
	transacs.remove(transac);
	
	int sucess=itemtransacdao.deleteItemTransaction(transacno);
	System.out.println(sucess);
}
public ItemTransactionDAO getItemtransacdao() {
	return itemtransacdao;
}
public void setItemtransacdao(ItemTransactionDAO itemtransacdao) {
	this.itemtransacdao = itemtransacdao;
}
@Override
@Transactional
public void updateqty(int tranc, int qty) {

	ItemTransactionDTO itemtransc=itemtransacdao.getItemTransaction(tranc);
	itemtransacdao.updateItemTransaction(itemtransc, qty);
	
}
}

