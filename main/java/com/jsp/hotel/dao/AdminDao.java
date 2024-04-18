package com.jsp.hotel.dao;

import com.jsp.hotel.entity.AdminInformation;

public interface AdminDao  {
	
	void adminRegistration(AdminInformation adminInformation);
	AdminInformation adminLogin(String emailid,String password);
	
}
