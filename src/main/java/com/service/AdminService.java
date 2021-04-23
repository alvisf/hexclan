package com.service;
 

import org.springframework.stereotype.Service;

import com.model.ItemDetailsDTO;


@Service("adminService")
public interface AdminService {
public void addItem(ItemDetailsDTO item);
public void editItem(ItemDetailsDTO item);
public void deleteItem(int uid);
public void deleteTransaction(int invno);
public void updateqty(int tranc,int qty);
}
