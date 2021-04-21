package com.dao;

import java.util.List;
import java.util.Set;

import com.model.InvoiceMasterDTO;
import com.model.ItemTransactionDTO;

public interface ItemTransactionDAO {
	public int insertItemTransaction(ItemTransactionDTO itemTransactionDTO);
	public int deleteItemTransaction(int transactionID);
	public int updateItemTransaction(ItemTransactionDTO itemTransactionDTO,int itemQuantity);
	public ItemTransactionDTO getItemTransaction(int transactionID);
	public List<ItemTransactionDTO> getItemTransactionAll();
	public List<ItemTransactionDTO> getItemTransactionForParticularInvoice(InvoiceMasterDTO invoiceMasterDTO);
}
