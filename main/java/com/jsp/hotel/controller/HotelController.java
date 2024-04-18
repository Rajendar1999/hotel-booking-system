package com.jsp.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsp.hotel.dao.HotelDao;
import com.jsp.hotel.entity.Hotel;

import jakarta.servlet.http.HttpSession;

@Controller
public class HotelController {
	
	@Autowired
	HotelDao hotelDao;
	
	@GetMapping("/Addhotel")
	public String getHotelPage(Model model) {
		model.addAttribute("hotelinformation", new Hotel());
		return "AddHotel";
	}
	@RequestMapping("/hotelDetails")
	public String hotelInformation(Hotel hotel) {
//		System.out.println(hotel);
		
		hotelDao.hotelRegistration(hotel);
		return "Home1";
	}
	
	@GetMapping("/HotelList")
	public String ListOfHotels(Model model) {
		
		List<Hotel> list = hotelDao.seletAllHotels();
		model.addAttribute("listOfHotels",list);

//		System.out.println(list);
		return "HotelList";
	}
	
	
	
	
	@RequestMapping("/updatehotelInfo")
	public String updateHotel(Hotel hotel,Model model,HttpSession session)
	{
//		session.setAttribute("hotelname", hotel.getHotelname());
		System.out.println("printing details");
		model.addAttribute("hotelinfo", hotel);
		System.out.println(hotel);
		return "UpdateHotel";
	}
	
	@RequestMapping("/updatehotelDetails")
	public String updatehotelInformation(Hotel hotel) {
		System.out.println(hotel);
		
		hotelDao.hotelRegistration(hotel);
		return "redirect:/HotelList";
	}
	
	
	@RequestMapping("/deletehotelInfo")
	public String deleteHotel(Hotel hotel) {
		hotelDao.deleteHotelDetails(hotel);
		return "redirect:/HotelList";
	}
	 
	
	@RequestMapping("/findHotel")
	public String findHotel(String city,Model model) {
		List<Hotel> list = hotelDao.selectAllHotels(city);
		model.addAttribute("listOfHotel", list);
		System.out.println(city);
		
		return "ListOfHotels";
	}
	
}
