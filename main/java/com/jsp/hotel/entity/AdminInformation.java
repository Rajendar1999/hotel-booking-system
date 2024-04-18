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
@AllArgsConstructor
@NoArgsConstructor
public class AdminInformation {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int adminid;
	private String firstname;
	private String lastname;
	private LocalDate dateofbirth;
	private String gender;
	@Column(unique = true,nullable = false)
	private String emailid;
	@Column(unique = true,nullable = false,length = 8)
	private String password;
	@Column(unique = true,nullable = false,length = 10)
	private String mobilenumber;
}
