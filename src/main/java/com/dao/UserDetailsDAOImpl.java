package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.UserDetailsDTO;


@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO,Cloneable{
	
	
	@Autowired
	private SessionFactory factory;
	
	public final SessionFactory getFactory() {
		return factory;
	}
	public final void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public int insertUserDetails(UserDetailsDTO userDetailsDTO) {
		Session session=factory.getCurrentSession();
		session.persist(userDetailsDTO);
		return 1;
	}
	 
	@Override
	public int deleteUserDetails(int uid) {
		Session session = factory.getCurrentSession();
		Object persistentInstance = session.get(UserDetailsDTO.class, uid);
	    if (persistentInstance != null) {
	        session.delete(persistentInstance);
	        return 1;
	    }
	    return 0;
	}
	
	@Override
	public int updateUserDetails(UserDetailsDTO userDetailsDTO,String uname){
		Session session = factory.getCurrentSession();
		
		userDetailsDTO.setUname(uname);
		session.update(userDetailsDTO);
		
		return 1;
	}
	
	
	@Override
	public UserDetailsDTO getUserDetail(int uid) {
		Session session = factory.getCurrentSession();
		
		Criteria criteria=session.createCriteria(UserDetailsDTO.class);
		criteria.add(Restrictions.eq("uid", uid));
		
		UserDetailsDTO userDetailsDTO=(UserDetailsDTO)criteria.uniqueResult();
		return userDetailsDTO;
		
	}
	
	
	@Override
	public List<UserDetailsDTO> getUserDetailsAll() {
		Session session=factory.getCurrentSession();
		
		Criteria criteria=session.createCriteria(UserDetailsDTO.class);
		List<UserDetailsDTO> users=criteria.list();
		
		return users;
	}
	
	
	@Override
	public UserDetailsDTO getUserDTObyName(String uname) {
		Session session = factory.getCurrentSession();
		
		Criteria criteria=session.createCriteria(UserDetailsDTO.class);
		criteria.add(Restrictions.eq("uname", uname));
		
		UserDetailsDTO userDetailsDTO=(UserDetailsDTO)criteria.uniqueResult();
		return userDetailsDTO;
	}
	
	@Override
	public int setFlag(UserDetailsDTO userDetailsDTO,int flag) {
		Session session = factory.getCurrentSession();
		
		userDetailsDTO.setFlag(flag);
		
		session.update(userDetailsDTO);
		
		return 1;
	}
}
