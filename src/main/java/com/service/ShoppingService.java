package com.service;

import java.util.HashMap;
import java.util.List;



import org.springframework.stereotype.Service;

import com.model.ItemDetailsDTO;


public interface ShoppingService {
	
public List<ItemDetailsDTO> dispallitems(String category);
public List<ItemDetailsDTO> allItems();
public void addItem(ItemDetailsDTO itemDTO);
public ItemDetailsDTO getItemById(int id);
public String getItemName(int itemNo);
public Double getItemPrice(int itemNo); 
public Double getTotal(List<ItemDetailsDTO> itemList);
public List<Integer> getCategories();
public int getItemNo(String name);
public ItemDetailsDTO getItemByName(String itemName);
public Double getTotal(HashMap<ItemDetailsDTO,Integer> itemList);

}
