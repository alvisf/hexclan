package com.dao;

import java.util.List;
import java.util.Set;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.model.ItemDetailsDTO;
import com.model.ItemTransactionDTO;

@Repository
public class ItemDAOImpl implements ItemDAO{
	@Autowired
	private SessionFactory factory;
	
	
	
@Override

public List<ItemDetailsDTO> getAllItems(String category) {
	Session session=factory.getCurrentSession();
	Criteria criteria=session.createCriteria(ItemDetailsDTO.class);
	criteria.add(Restrictions.eq("itemCategory", category));
	List<ItemDetailsDTO> items=criteria.list();
	return items;
}


public SessionFactory getFactory() {
	return factory;
}


public void setFactory(SessionFactory factory) {
	this.factory = factory;
}


@Override
public void createItem(ItemDetailsDTO item) {
	Session session=factory.getCurrentSession();
	session.persist(item);	
}


@Override
public ItemDetailsDTO getItemById(int id) {
	Session session = factory.getCurrentSession();		
	Criteria criteria = session.createCriteria(ItemDetailsDTO.class);
    criteria.add(Restrictions.idEq(id));
    ItemDetailsDTO item=(ItemDetailsDTO)criteria.uniqueResult();
    return item;
}
@Override
public List<ItemDetailsDTO> getEveryItem() {
	Session session=factory.getCurrentSession();
	List<ItemDetailsDTO> items = session.createQuery("from itemDetailsDTO").list();
	return items;
}
@Override
public void deleteitem(int uid) {
	Session session = factory.getCurrentSession();
	Object persistentInstance = session.get(ItemDetailsDTO.class, uid);
    if (persistentInstance != null) {
        session.delete(persistentInstance);
        //return 1;
    }
    //return 0;
	
}
@Override
public void updateitem(ItemDetailsDTO item) {
	Session session=factory.getCurrentSession();
	session.saveOrUpdate(item);
	
	
}
	
}

