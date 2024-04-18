package com.jsp.hotel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.hotel.entity.AdminInformation;
import com.jsp.hotel.repository.AdminRepository;

@Component
public class AdminDaoImp implements AdminDao{
	
	@Autowired
	AdminRepository repository;
	
	@Override
	public void adminRegistration(AdminInformation adminInformation) {
		AdminInformation information = repository.save(adminInformation);
	}

	@Override
	public AdminInformation adminLogin(String emailid, String password) {
		return repository.findByEmailidAndPassword(emailid, password);
	}

}
