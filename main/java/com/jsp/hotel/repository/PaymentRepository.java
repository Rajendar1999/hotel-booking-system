package com.jsp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hotel.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
