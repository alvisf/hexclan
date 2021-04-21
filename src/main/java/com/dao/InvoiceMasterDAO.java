package com.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.model.InvoiceMasterDTO;
import com.model.UserDetailsDTO;

public interface InvoiceMasterDAO {
	public int insertInvoice(InvoiceMasterDTO invMasterDTO);
	public int deleteInvoice(int invno);
	public int updateInvoice(InvoiceMasterDTO invMasterDTO,LocalDate date);
	public InvoiceMasterDTO getInvoiceMaster(int invno);
	public List<InvoiceMasterDTO> getInvoiceMasterAll();
	//public int getLength();
}