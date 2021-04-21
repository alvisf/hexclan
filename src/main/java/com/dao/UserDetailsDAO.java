package com.dao;

import java.util.List;
import java.util.Set;

import com.model.UserDetailsDTO;

public interface UserDetailsDAO {
	public int insertUserDetails(UserDetailsDTO userDetailsDTO);
	public int deleteUserDetails(int uid);
	public int updateUserDetails(UserDetailsDTO userDetailsDTO,String uname);
	public UserDetailsDTO getUserDetail(int uid);
	public List<UserDetailsDTO> getUserDetailsAll();
	public UserDetailsDTO getUserDTObyName(String uname);
	public int setFlag(UserDetailsDTO userDetailsDTO,int flag);
}
