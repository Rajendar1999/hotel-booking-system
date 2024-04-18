package com.jsp.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.hotel.dao.AdminDao;
import com.jsp.hotel.entity.AdminInformation;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
	
	@Autowired
	AdminDao adminDao;
	
	@GetMapping("/Home1")
	public String AdminHomepage() {
		return "Home1";
	}
	
	@GetMapping("/Admin")
	public String adminregistration() {
		return "redirect:/AdminSign";
	}
	
	@GetMapping("/AdminSign")
	public String adminPage(Model model) {
		model.addAttribute("adminInfo", new AdminInformation());
		return "AdminSignUp";
	}
	
	@RequestMapping("/adminRegistration")
	public String adminInfo(AdminInformation adminInformation) {
		System.out.println(adminInformation);
		adminDao.adminRegistration(adminInformation);
		return "AdminLogin";
	}
	@GetMapping("/AdminLogin")
	public String adminLoginPage() {
		return "AdminLogin";
	}
	
	@RequestMapping("/adminLoginReq")
	public ModelAndView adminLogin(String emailid,String password,HttpServletRequest request,ModelAndView modelAndView) {
		
		AdminInformation adminInformation = adminDao.adminLogin(emailid, password);
		request.getSession().setAttribute("AdminInformation", adminInformation);
		if (adminInformation!=null) {
			modelAndView.setViewName("Home1");
			return modelAndView;
		} else {
			modelAndView.setViewName("AdminLogin");
			modelAndView.addObject("msg", "Invalid Details");
			return modelAndView;
		}
		
	}
	
	@GetMapping("/AdminLogOut")
	public String adminLogout() {
		return "redirect:/AdminLogin";
	}
}
