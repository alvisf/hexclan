package com.service;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.InvoiceMasterDAO;
import com.dao.InvoiceMasterDAOImpl;
import com.dao.ItemDetailsDAOImpl;
import com.dao.ItemTransactionDAO;
import com.dao.ItemTransactionDAOImpl;
import com.dao.UserDetailsDAOImpl;
import com.model.InvoiceMasterDTO;
import com.model.ItemDetailsDTO;
import com.model.ItemTransactionDTO;
import com.model.UserDetailsDTO;

@Service
@Transactional
public class XMLServiceImpl implements XMLService,Cloneable{
	
	
	@Autowired
	private InvoiceMasterDAO invoiceMasterDAO;
	
	@Autowired
	private ItemTransactionDAO itemTransactionDAO;
	
	@Autowired
	private ItemDetailsDAOImpl itemDetailsDAO;

	@Override
	public String createXML(int invNo, Double total) {
//		UserDetailsDAOImpl customerImpl = UserDetailsDAOImpl.getCustomerDetailsDAOImpl();
//		InvoiceMasterDAOImpl invImpl = InvoiceMasterDAOImpl.getInvoiceMasterDAOImpl();
//		ItemTransactionDAOImpl transacImpl =ItemTransactionDAOImpl.getItemTransactionDAOImpl();
//		ItemDetailsDAOImpl itemImpl = ItemDetailsDAOImpl.getItemDetailsDAOImpl();
		
		FileWriter fileWriter;
		
		StringBuilder xml = new StringBuilder();
		InvoiceMasterDTO inv1 = invoiceMasterDAO.getInvoiceMaster(invNo);
		
		UserDetailsDTO customer1 = inv1.getUserDetailsDTO();
		
		List<ItemTransactionDTO> set = new ArrayList<ItemTransactionDTO>();
		
		set = itemTransactionDAO.getItemTransactionForParticularInvoice(inv1);
		String path2 = System.getProperty("user.dir");
		System.out.println(path2);
		xml.append("<!DOCTYPE invoice SYSTEM "+"\""+path2+ "\\src\\main\\webapp\\invoice.dtd\">");
		xml.append("<invoice>");
		xml.append("<customername>");
		xml.append(customer1.getUname());
		xml.append("</customername>");
		xml.append("<invno>");
		xml.append(invNo);
		xml.append("</invno>");
		xml.append("<invdate>");
		xml.append(inv1.getInvDate());
		xml.append("</invdate>");
		xml.append("<items>");
		Iterator<ItemTransactionDTO> iter = set.iterator();
		while(iter.hasNext()) {
			ItemTransactionDTO transac1 = iter.next();
			int itemNo = transac1.getItemDetailsDTO().getItemNo();
			ItemDetailsDTO item1 = itemDetailsDAO.getItemDetails(itemNo);
			xml.append("<item>");
			xml.append("<itemno>");
			xml.append(item1.getItemNo());
			xml.append("</itemno>");
			xml.append("<itemname>");
			xml.append(item1.getItemDesc());
			xml.append("</itemname>");
			xml.append("<itemprice>");
			xml.append(item1.getItemPrice());
			xml.append("</itemprice>");
			xml.append("<itemquantity>");
			xml.append(transac1.getItemQuantity());
			xml.append("</itemquantity>");
			xml.append("<itemamount>");
			xml.append(item1.getItemPrice() * transac1.getItemQuantity());
			xml.append("</itemamount>");
			xml.append("</item>");
		}
		
		xml.append("</items>");
		xml.append("<gst></gst>");
		xml.append("<net>");
		xml.append(total);
		xml.append("</net>");
		xml.append("</invoice>");
		
		try {
			File output = new File(path2+ "/src/main/webapp/invoice.xml");
			System.out.println(output);
			if(output.createNewFile()) {
				fileWriter = new FileWriter(output);
			}
			else {
				fileWriter = new FileWriter(output,false);
			}
			
			fileWriter.write(xml.toString());
			fileWriter.flush();
			fileWriter.close();
			
			return output.getAbsolutePath();
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
