package com.service;

import java.util.List;

import com.model.ItemDetailsDTO;
import com.model.ItemTransactionDTO;

public interface ManagerService {
public List<ItemTransactionDTO> getReportByInvno(int invno);
public List<ItemTransactionDTO> getAllReports();
public List<ItemDetailsDTO> getReportByDate(int invno);
public List<ItemTransactionDTO> getReportByCustomerID(int custid);
public void test(int invno);









}
