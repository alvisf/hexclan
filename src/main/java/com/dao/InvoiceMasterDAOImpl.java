package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
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

import com.model.InvoiceMasterDTO;

@Repository
public class InvoiceMasterDAOImpl implements InvoiceMasterDAO,Cloneable{

	
	@Autowired
	private SessionFactory factory;
	
	public final SessionFactory getFactory() {
		return factory;
	}
	public final void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public int insertInvoice(InvoiceMasterDTO invMasterDTO) {
		Session session=factory.getCurrentSession();
		session.persist(invMasterDTO);
		return 1;
	}
	
	@Override
	public int deleteInvoice(int invno) {
		Session session = factory.getCurrentSession();
		Object persistentInstance = session.get(InvoiceMasterDTO.class, invno);
	    if (persistentInstance != null) {
	        session.delete(persistentInstance);
	        return 1;
	    }
	    return 0;
	}
	@Override
	public int updateInvoice(InvoiceMasterDTO invMasterDTO,LocalDate date) {
		Session session = factory.getCurrentSession();
		
		invMasterDTO.setInvDate(date);
		session.update(invMasterDTO);
		
		return 1;
	}
	@Override
	public InvoiceMasterDTO getInvoiceMaster(int invno) {
		Session session = factory.getCurrentSession();
		
		Criteria criteria=session.createCriteria(InvoiceMasterDTO.class);
		criteria.add(Restrictions.eq("invNo", invno));
		
		InvoiceMasterDTO invMasterDTO=(InvoiceMasterDTO)criteria.uniqueResult();
		return invMasterDTO;
	}
	@Override
	public List<InvoiceMasterDTO> getInvoiceMasterAll() {
		Session session=factory.getCurrentSession();
		
		Criteria criteria=session.createCriteria(InvoiceMasterDTO.class);
		List<InvoiceMasterDTO> invoices=criteria.list();
		return invoices;
}
	
//	public int getLength() {
//		Session session=factory.getCurrentSession();
//	}
	

}