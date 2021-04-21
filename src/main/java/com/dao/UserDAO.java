package com.dao;

import com.model.UserDetailsDTO;



public interface UserDAO {
	public void createUser(UserDetailsDTO user);
	public UserDetailsDTO getUserByName(String uname);
	public UserDetailsDTO getUserById(int id);
	
	
}
;