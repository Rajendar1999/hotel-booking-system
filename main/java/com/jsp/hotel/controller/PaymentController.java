package com.jsp.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsp.hotel.dao.PaymentDao;
import com.jsp.hotel.entity.Payment;

@Controller
public class PaymentController {
	
	@Autowired
	PaymentDao paymentDao;
	
	@RequestMapping("/takingpaymentDetails")
	public String takingPaymentdetails(Payment payment) {
		System.out.println(payment);
		paymentDao.paymentRegister(payment);
		return "BookingConfirmMessage";
	}
	
	@GetMapping("/PaymentList")
	public String paymentlist(Model model) {
		List<Payment> allPayments = paymentDao.selectAllPayments();
		model.addAttribute("allPayments", allPayments);
		return "Payment";
	}
	
}
