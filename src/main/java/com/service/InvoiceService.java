package com.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.model.InvoiceMasterDTO;
import com.model.ItemDetailsDTO;
import com.model.UserDetailsDTO;

public interface InvoiceService {
	public void insertInvoices(String uname,HashMap<ItemDetailsDTO,Integer> items,HttpSession session);
}
