package com.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDAO;
import com.dao.UserDetailsDAO;
import com.model.UserDetailsDTO;


@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private UserDetailsDAO userDetailsDao;
	
	public final UserDAO getUserDao() {
		return userDao;
	}
	public final void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
@Override
@Transactional
public void createUser(UserDetailsDTO customer) {
	userDao.createUser(customer);
}
@Override
@Transactional
public boolean checkLogin(String uname) {
	
	UserDetailsDTO user=userDao.getUserByName(uname);
	
	if(user!=null) {
		if(user.getFlag()==0) {
			return true;
		}else {
			return false;
		}
	}else {
		return false;
	}
}
@Override
@Transactional
public boolean checkUser(String uname, String upass) {
	
	UserDetailsDTO user=userDao.getUserByName(uname);
	if(user!=null) {
		if(user.getUpass().equals(upass)) {
			return true;
		}else {
			return false;
		}
	}else {
		return false;
	}
	
}
@Override
@Transactional
public void updateLogin(String uname,int flag) {
	UserDetailsDTO user=userDao.getUserByName(uname);
	if(user!=null) {
		userDetailsDao.setFlag(user, flag);
	}


	
}
@Override
@Transactional
public int getUserId(String uname) {
	UserDetailsDTO user=userDao.getUserByName(uname);
	
	
	return user.getUid();
	
}
@Override
@Transactional
public UserDetailsDTO getUser(String uname) {
	return userDao.getUserByName(uname);
}


}
