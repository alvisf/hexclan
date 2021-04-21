package com.dao;

import java.util.List;


import com.model.ItemDetailsDTO;


public interface ItemDAO {
public List<ItemDetailsDTO>getAllItems(String category);
public void createItem(ItemDetailsDTO item);
public ItemDetailsDTO getItemById(int id);
public List<ItemDetailsDTO>getEveryItem();
public void deleteitem(int uid);
public void updateitem(ItemDetailsDTO item);

}
