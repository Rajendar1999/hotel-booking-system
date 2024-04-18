package com.jsp.hotel.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.hotel.entity.Payment;
import com.jsp.hotel.repository.PaymentRepository;

@Component
public class PaymentDaoImp implements PaymentDao {

	@Autowired
	PaymentRepository paymentRepository;
	
	@Override
	public void paymentRegister(Payment payment) {
		// TODO Auto-generated method stub
		Payment payment2 = paymentRepository.save(payment);
		
		
	}

	@Override
	public List<Payment> selectAllPayments() {
		return  paymentRepository.findAll();
	}

}
