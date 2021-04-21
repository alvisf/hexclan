package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.InvoiceMasterDTO;
import com.model.ItemDetailsDTO;
import com.model.ItemTransactionDTO;
import com.model.UserDetailsDTO;
@Repository
public class ReportDAOImpl implements ReportDao{
	
	@Autowired
	private SessionFactory factory;
	
	public final SessionFactory getFactory() {
		return factory;
	}
	public final void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
@Override
public void getItemByInvoice(int invno) {
	Session session=factory.getCurrentSession();
	HashMap<Integer, Integer> finitems=new HashMap<Integer,Integer>();

	Query query= session.createQuery("FROM itemTransactionDTO E WHERE E.invNo = :invno");
	query.setParameter("invno", invno);
	List<ItemTransactionDTO> items=query.list();
	
    System.out.println(items);
   
}
@Override
public InvoiceMasterDTO getInvoicMasterByInvoice(int invno) {
	
	Session session=factory.getCurrentSession();
	Query query= session.createQuery("FROM invoiceMasterDTO E WHERE E.invNo = :invno");
	InvoiceMasterDTO items =(InvoiceMasterDTO)query.setParameter("invno", invno).uniqueResult();
	
	return items;
	
}
@Override
public List<ItemTransactionDTO> getItemTransactionByInvoice(InvoiceMasterDTO invoice) {
	Session session=factory.getCurrentSession();
	Query query= session.createQuery("FROM itemTransactionDTO E WHERE E.invoiceMasterDTO = :invoice");
	List<ItemTransactionDTO> items=query.setParameter("invoice", invoice).list();
	
	return items;
}
@Override
public List<InvoiceMasterDTO> getInvoiceByUser(UserDetailsDTO user) {
	Session session=factory.getCurrentSession();
	Query query= session.createQuery("FROM invoiceMasterDTO E WHERE E.userDetailsDTO = :user");
	List<InvoiceMasterDTO> items=query.setParameter("user", user).list();
	
	return items;
}
@Override
public List<ItemTransactionDTO> getAllTransaction() {
	Session session=factory.getCurrentSession();
	
	Criteria criteria=session.createCriteria(ItemTransactionDTO.class);
	List<ItemTransactionDTO> items=criteria.list();
	System.out.println(items);
	return items;
}
@Override
public List<ItemTransactionDTO> getByList(List<InvoiceMasterDTO> inv) {
	Session session=factory.getCurrentSession();
	ListIterator iterator = inv.listIterator();
	InvoiceMasterDTO invoice=new InvoiceMasterDTO();
	List<ItemTransactionDTO> altertrans=new ArrayList<ItemTransactionDTO>();
	List<ItemTransactionDTO> trans=new ArrayList<ItemTransactionDTO>();
	ItemTransactionDTO itd=new ItemTransactionDTO();
	while(iterator.hasNext()) {
		
		invoice=(InvoiceMasterDTO)iterator.next();
		altertrans=getItemTransactionByInvoice(invoice);
		
		ListIterator iterator2 = altertrans.listIterator();
		while(iterator2.hasNext()) {
			itd=(ItemTransactionDTO)iterator2.next();
			trans.add(itd);
			
		}



		}
	return trans;
}
}
