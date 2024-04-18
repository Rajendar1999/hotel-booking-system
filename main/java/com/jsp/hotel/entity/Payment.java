package com.jsp.hotel.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int paymentid;
	@Column(length = 19,nullable = false)
	private String cardnumber;
	private String cardholdername;
	private LocalDate expirydate;
	private double price;
	
	
}
