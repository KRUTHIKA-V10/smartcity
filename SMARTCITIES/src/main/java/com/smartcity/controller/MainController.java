package com.smartcity.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.smartcity.model.Details;
import com.smartcity.service.DetailsService;


//@Controller
public class MainController {

	
//	private DetailsService detailService;
//	
//	public MainController(DetailsService detailService) {
//		super();
//		this.detailService = detailService;
//	}
//	@RequestMapping("/")
//	public String loginPage()
//	{
//		return "login";
//	}
//	@RequestMapping("/register")
//	public String registerPage()
//	{
//		return "register";
//	}
//	
	/*
	 * @GetMapping("/home") public ModelAndView homePage(HttpServletRequest
	 * request,ModelAndView model ,Details detaillist) {
	 * //request.setAttribute("detailslist",detailService.showAllDetails());
	 * 
	 * List<Details> listEmp = detailService.showAllDetails();
	 * model.addObject("listEmp", listEmp); model.setViewName("home"); return model;
	 * }
	 */
}
