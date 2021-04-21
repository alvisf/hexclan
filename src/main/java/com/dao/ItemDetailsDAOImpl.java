package com.dao;

import java.io.FileInputStream;

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

import com.model.ItemDetailsDTO;
import com.model.ItemTransactionDTO;

@Repository
public class ItemDetailsDAOImpl implements ItemDetailsDAO,Cloneable{
	

	
	@Autowired
	private SessionFactory factory;
	
	public final SessionFactory getFactory() {
		return factory;
	}
	public final void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	

	
	@Override
	public int insertItemDetails(ItemDetailsDTO itemDetailsDTO) {
		Session session=factory.getCurrentSession();
		session.persist(itemDetailsDTO);
		return 1;
	}
	
	@Override
	public ItemDetailsDTO getItemDetails(int itemNo) {
		Session session = factory.getCurrentSession();
		
		Criteria criteria=session.createCriteria(ItemDetailsDTO.class);
		criteria.add(Restrictions.eq("itemNo", itemNo));
		
		ItemDetailsDTO itemDetailsDTO=(ItemDetailsDTO)criteria.uniqueResult();
		return itemDetailsDTO;
		
	}
	
	@Override
	public List<ItemDetailsDTO> getItemDetailsAll(){
		Session session=factory.getCurrentSession();
		
		Criteria criteria=session.createCriteria(ItemDetailsDTO.class);
		List<ItemDetailsDTO> items=criteria.list();
		
		return items;
	}
	
	@Override
	public List<ItemDetailsDTO> getItemDetailsByCategory(String itemCategory){
		Session session = factory.getCurrentSession();
		
		Criteria criteria=session.createCriteria(ItemDetailsDTO.class);
		criteria.add(Restrictions.eq("itemCategory", itemCategory));
		
		List<ItemDetailsDTO> items=criteria.list();
		
		return items;
	}
	
	@Override
	public int deleteItemDetails(ItemDetailsDTO itemDetailsDTO){
		Session session = factory.getCurrentSession();
        session.delete(itemDetailsDTO);
        return 1;
	}
	
	@Override
	public int updateItemDetails(ItemDetailsDTO updatedItemDetailsDTO){
		Session session = factory.getCurrentSession();
		
		session.merge(updatedItemDetailsDTO);
		
		return 1;
	}
	
	@Override
	public List<Integer> getCategories() {
		Session session = factory.getCurrentSession();
		
		Query query=session.createQuery	("select distinct categoryID from itemDetailsDTO item ");
		
		List<Integer> list = query.list();
		return list;
	}
	
	@Override
	public int getItemNo(String name) {
		Session session = factory.getCurrentSession();
		
		Criteria criteria=session.createCriteria(ItemDetailsDTO.class);
		criteria.add(Restrictions.eq("itemDesc", name));
		ItemDetailsDTO itemDetailsDTO=(ItemDetailsDTO)criteria.uniqueResult();
		
		return itemDetailsDTO.getItemNo();
	}	
	
	@Override
	public ItemDetailsDTO getItemDetailByName(String itemName) {
		Session session = factory.getCurrentSession();
		
		Criteria criteria=session.createCriteria(ItemDetailsDTO.class);
		criteria.add(Restrictions.eq("itemDesc", itemName));
		
		ItemDetailsDTO itemDetailsDTO=(ItemDetailsDTO)criteria.uniqueResult();
		return itemDetailsDTO;
	}
	

	
}
