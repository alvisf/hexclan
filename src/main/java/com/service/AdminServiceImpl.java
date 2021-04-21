package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ItemDAO;
import com.dao.UserDAO;
import com.model.ItemDetailsDTO;



@Service("adminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private ItemDAO itemDao;
	

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
	itemDao.deleteitem(uid);
	
}


}

