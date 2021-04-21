package com.dao;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.UserDetailsDTO;


@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	private SessionFactory factory;
	
	public final SessionFactory getFactory() {
		return factory;
	}
	public final void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
@Override
public void createUser(UserDetailsDTO user) {

	Session session=factory.getCurrentSession();
	session.persist(user);
}
@Override
public UserDetailsDTO getUserByName(String uname) {
	Session session=factory.getCurrentSession();
	Criteria criteria=session.createCriteria(UserDetailsDTO.class);
	criteria.add(Restrictions.eq("uname", uname));
	return (UserDetailsDTO)criteria.uniqueResult();
}
@Override
public UserDetailsDTO getUserById(int id) {
	Session session=factory.getCurrentSession();
	Criteria criteria=session.createCriteria(UserDetailsDTO.class);
	criteria.add(Restrictions.eq("uid", id));
	return (UserDetailsDTO)criteria.uniqueResult();
}

}
