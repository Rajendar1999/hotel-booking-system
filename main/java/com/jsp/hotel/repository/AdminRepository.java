package com.jsp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hotel.entity.AdminInformation;

public interface AdminRepository extends JpaRepository<AdminInformation, Integer>{
	AdminInformation findByEmailidAndPassword(String emailid,String password);
}
