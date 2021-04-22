package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.InvoiceMasterDTO;
import com.model.ItemTransactionDTO;


@Repository
public class ItemTransactionDAOImpl implements ItemTransactionDAO,Cloneable{
	
	
	@Autowired
	private SessionFactory factory;
	
	public final SessionFactory getFactory() {
		return factory;
	}
	public final void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	
	
	@Override
	public int insertItemTransaction(ItemTransactionDTO itemTransactionDTO) {
		Session session=factory.getCurrentSession();
		session.merge(itemTransactionDTO);
		return 1;
	}
	
	@Override
	public int deleteItemTransaction(int transactionID) {
		Session session = factory.getCurrentSession();
		Object persistentInstance = session.get(ItemTransactionDTO.class, transactionID);
	    if (persistentInstance != null) {
	        session.delete(persistentInstance);
	        return 1;
	    }
	    return 0;
	}
	
	@Override
	public int updateItemTransaction(ItemTransactionDTO itemTransactionDTO,int itemQuantity) {
		Session session = factory.getCurrentSession();
		
//		Criteria criteria=session.createCriteria(ItemTransactionDTO.class);
//		criteria.add(Restrictions.eq("comKey1", new CompKey1(2,1)));
//		ItemTransactionDTO itemTransactionDTO=(ItemTransactionDTO)criteria.uniqueResult();
		
		itemTransactionDTO.setItemQuantity(itemQuantity);
		session.update(itemTransactionDTO);
		
		return 1;
	}
	
	@Override
	public ItemTransactionDTO getItemTransaction(int transactionID) {
		Session session = factory.getCurrentSession();
		
		Criteria criteria=session.createCriteria(ItemTransactionDTO.class);
		criteria.add(Restrictions.eq("transactionID", transactionID));
		ItemTransactionDTO itemTransactionDTO=(ItemTransactionDTO)criteria.uniqueResult();
		
		return itemTransactionDTO;
	}
	
	@Override
	public List<ItemTransactionDTO> getItemTransactionAll() {
		Session session=factory.getCurrentSession();
		
		Criteria criteria=session.createCriteria(ItemTransactionDTO.class);
		List<ItemTransactionDTO> transactions=criteria.list();
		
		return transactions;
	}
	
	@Override
	public List<ItemTransactionDTO> getItemTransactionForParticularInvoice(InvoiceMasterDTO invoiceMasterDTO) {
		Session session = factory.getCurrentSession();
		
		Criteria criteria=session.createCriteria(ItemTransactionDTO.class);
		criteria.add(Restrictions.eq("invoiceMasterDTO", invoiceMasterDTO));
		List<ItemTransactionDTO> transactions=criteria.list();
		
		return transactions;
	}
	
}
