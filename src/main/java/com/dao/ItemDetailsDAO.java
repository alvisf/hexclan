package com.dao;

import java.util.List;
import java.util.Set;

import com.model.ItemDetailsDTO;


public interface ItemDetailsDAO {
	public int insertItemDetails(ItemDetailsDTO itemDetailsDTO);
	public int deleteItemDetails(ItemDetailsDTO itemDetailsDTO);
	public int updateItemDetails(ItemDetailsDTO updatedItemDetailsDTO);
	public ItemDetailsDTO getItemDetails(int itemNo);
	public List<ItemDetailsDTO> getItemDetailsByCategory(String itemCategory);
	public List<ItemDetailsDTO> getItemDetailsAll();
	public List<Integer> getCategories();
	public int getItemNo(String name);
	public ItemDetailsDTO getItemDetailByName(String itemName);
}
