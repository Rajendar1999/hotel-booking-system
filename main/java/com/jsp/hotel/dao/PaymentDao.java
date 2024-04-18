package com.jsp.hotel.dao;

import java.util.List;

import com.jsp.hotel.entity.Payment;

public interface PaymentDao {
	void paymentRegister(Payment payment);
	List<Payment> selectAllPayments();
}
