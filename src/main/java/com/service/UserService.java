package com.service;

import org.springframework.stereotype.Service;

import com.model.UserDetailsDTO;



public interface UserService {
	public void createUser(UserDetailsDTO customer);
	public boolean checkLogin(String uname);
	public boolean checkUser(String uname,String upass);
	public void updateLogin(String uname,int flag);
	public int getUserId(String uname);
	public UserDetailsDTO getUser(String uname);
}
