package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ItemDAO;
import com.dao.ItemDetailsDAO;
import com.model.ItemDetailsDTO;

@Service("shoppingService")
public class ShoppingServiceImpl implements ShoppingService {
	
	@Autowired
	private ItemDAO itemDao;
	
	@Autowired
	private ItemDetailsDAO itemDetailsDAO;
	


	public ItemDetailsDAO getItemDetailsDAO() {
		return itemDetailsDAO;
	}

	public void setItemDetailsDAO(ItemDetailsDAO itemDetailsDAO) {
		this.itemDetailsDAO = itemDetailsDAO;
	}

	@Override
	@Transactional
	public List<ItemDetailsDTO> dispallitems(String category) {
		List<ItemDetailsDTO>list=new ArrayList<ItemDetailsDTO>();
		list=itemDao.getAllItems(category);
		return list;
	}

	public ItemDAO getItemDao() {
		return itemDao;
	}

	public void setItemDao(ItemDAO itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	@Transactional
	public void addItem(ItemDetailsDTO item) {
		itemDao.createItem(item);
		
	}

	@Override
	@Transactional
	public ItemDetailsDTO getItemById(int id) {
		
		ItemDetailsDTO item=itemDao.getItemById(id);	
		return item;
	}
@Override
@Transactional
public List<ItemDetailsDTO> allItems() {
	List<ItemDetailsDTO>items=itemDao.getEveryItem();
	
	return items;
}
@Override
@Transactional
public ItemDetailsDTO getItemByName(String itemName) {
	return itemDetailsDAO.getItemDetailByName(itemName);
}

@Override
@Transactional
public String getItemName(int itemNo) {
	ItemDetailsDTO itemDetailsDTO = itemDetailsDAO.getItemDetails(itemNo);
	return itemDetailsDTO.getItemDesc();
}

@Override
@Transactional
public Double getItemPrice(int itemNo) {
	ItemDetailsDTO itemDetailsDTO = itemDetailsDAO.getItemDetails(itemNo);
	return itemDetailsDTO.getItemPrice();
}

@Override
@Transactional
public Double getTotal(List<ItemDetailsDTO> itemList) {
	Double total = 0.0;
	for(ItemDetailsDTO item:itemList) {
		total= total + item.getItemPrice();
	}
	return total;
}

@Override
@Transactional
public Double getTotal(HashMap<ItemDetailsDTO,Integer> selecteditems) {
	Double total = 0.0;
	for (Map.Entry<ItemDetailsDTO, Integer> set : selecteditems.entrySet()) {
		total = total + set.getKey().getItemPrice() * set.getValue() ;
	}
	return total;
}

@Override
@Transactional
public List<Integer> getCategories() {
	List<Integer> list = itemDetailsDAO.getCategories();
	return list;
}

@Override
@Transactional
public int getItemNo(String name) {
	return itemDetailsDAO.getItemNo(name);
}


}
