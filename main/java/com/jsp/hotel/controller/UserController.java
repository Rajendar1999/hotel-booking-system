package com.jsp.hotel.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.hotel.dao.UserInformationDao;
import com.jsp.hotel.entity.Hotel;
import com.jsp.hotel.entity.UserInformation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	UserInformationDao dao;
	
	@GetMapping("/User")
	public String adminregistration() {
		return "redirect:/SignUpPage";
	}
	
	@RequestMapping("/HomePage")
	private String home() {
		return "Home";
	}
	
	@GetMapping("/Home")
	public String homePage() {
		return "Home";
	}
	
	@GetMapping("/SignUpPage")
	public String signUpPage(Model model) {
		model.addAttribute("userinfo", new UserInformation());
		return "SignUp";
	}
	
	@GetMapping("/Login")
	public String loginPage() {
		return "Login";
	}
	
	@GetMapping("/AddUsers")
	public String addUsers(Model model) {
		model.addAttribute("userinfo", new UserInformation());
		return "AddUsers";
	}
	
	@RequestMapping("/adminUserregistration")
	public String adduserregistrationbyadmin(UserInformation userInformation) 
	{
		dao.userRegistration(userInformation);
		return "Home1";
		
	}
	
	@RequestMapping("/registration")
	public String userRegistration(UserInformation userInformation) {
		dao.userRegistration(userInformation);
		return "Login";
	}
	
	@RequestMapping("userLoginreq")
	public String userlogin() {
		return "Login";
	}
	@RequestMapping("/returnSeachByCityPage")
	public String returnSearchCityPage(HttpServletRequest request) {
		UserInformation userInformation =(UserInformation)request.getSession().getAttribute("userlogininfo");
		request.getSession().setAttribute("userlogininfo", userInformation);
		return "SearchByCity";
		
	}
	
	
	@RequestMapping("/userLogin")
	//@ResponseBody
	private ModelAndView userloginInfo(String emailid,String password,HttpServletRequest request,ModelAndView modelAndView) {
		
//		String emailid="banothrajendar200@gmail.com";
//		String password="12345";
		
		UserInformation information = dao.userLogin(emailid, password);
		request.getSession().setAttribute("userlogininfo", information);
		if (information!=null) {
			modelAndView.setViewName("SearchByCity");
			return modelAndView;
		} else {
			modelAndView.setViewName("Login");
			modelAndView.addObject("msg", "Invalid Details");
			return modelAndView;
			
		}
	}
	
	@GetMapping("/UserList")
	public String listofUsers(Model model){
		List<UserInformation> allUsers = dao.selectAllUsers();
		model.addAttribute("userlist", allUsers);
		return "UsersList";
	}
	
	@GetMapping("/LogOut")
	public String logOut(){
		return "redirect:/userLogin";
	}
	
	@RequestMapping("/updateUser")
	public String updateuser(UserInformation userInformation,Model model,HttpSession session) {
		System.out.println("Printing");
		
		String date=userInformation.getDateofbirth()+"";
		String year=date.substring(0, 4);
		String month=date.substring(5, 7);
		String day=date.substring(8);
		String date2=day+"-"+month+"-"+year;
		System.out.println(date2);
		model.addAttribute("userinfor", userInformation);
		model.addAttribute("dateofbirth", date2);
		System.out.println(userInformation);
		return "UpdateUser";
	}
	
	
	@RequestMapping("/updateUserInformation")
	public String updateUserInfo(UserInformation userInformation) {
		dao.userRegistration(userInformation);
		return "redirect:/UserList";
	}
}
