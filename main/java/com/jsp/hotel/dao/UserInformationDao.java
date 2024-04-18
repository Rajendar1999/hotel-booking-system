package com.jsp.hotel.dao;

import java.util.List;

import com.jsp.hotel.entity.UserInformation;

public interface UserInformationDao {
	void userRegistration(UserInformation userInformation);
	UserInformation userLogin(String emailid,String password);
	List<UserInformation> selectAllUsers();

}