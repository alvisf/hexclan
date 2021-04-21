package com.dao;

import java.util.HashMap;
import java.util.List;

import com.model.InvoiceMasterDTO;
import com.model.ItemDetailsDTO;
import com.model.ItemTransactionDTO;
import com.model.UserDetailsDTO;

public interface ReportDao {

	public void getItemByInvoice(int invno);
	public InvoiceMasterDTO getInvoicMasterByInvoice(int invno);
	public List<ItemTransactionDTO> getItemTransactionByInvoice(InvoiceMasterDTO invoice);
	public List<InvoiceMasterDTO> getInvoiceByUser(UserDetailsDTO user);
	public List<ItemTransactionDTO> getAllTransaction();
	public List<ItemTransactionDTO> getByList(List<InvoiceMasterDTO> inv);

}
