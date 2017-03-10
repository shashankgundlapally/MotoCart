package com.nkart.shoppingcart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nkart.shoppingcart.dao.UserDAO;
import com.nkart.shoppingcart.domain.User;

@Controller
public class HomeController 
{
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private User user;
	
	@Autowired
	private HttpSession session;
	
	/* http://localhost:8080/nkart/ */
	
	//Navigating to a specific page statically
	@RequestMapping("/")
public ModelAndView showHomePage()
{
		
		//specifying which page to navigate
	ModelAndView mv = new ModelAndView("/Home");
	
	//specify what data you have to carry to home page
	mv.addObject("msg", "WELCOME TO NKART");
	
	return mv;
}
	
	
	@RequestMapping("/Login")
	public ModelAndView showLoginPage()
	{
		System.out.println("clicked on login");
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserClickedLogin", "true");
		return mv;
		
}
	
	
	
	@RequestMapping("/Registration")
	public ModelAndView showRegisterPage()
	{
		System.out.println("clicked on Reg");
		ModelAndView mv =new ModelAndView("/Home");
		mv.addObject("isUserClickedRegister", "true");
		return mv;
		
	}
	
	
	//@RequestMapping("/validate")  //used for get method
	@PostMapping("/validate")  //used for post method
	public ModelAndView validateCredentials(@RequestParam("userID") String id,@RequestParam("password") String pwd)
	{
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserLoggedIn", "false");
		if(userDAO.validate(id, pwd)==true)
		{
			
			user = userDAO.getUserById(id);
			
			if(user.getRole().equals("admin"))
			{
				mv.addObject("isAdmin",true);
			}
			else if(user.getRole().equals("user"))
			{
				mv.addObject("isAdmin", false);
			}
			mv.addObject("successMessage","valid credentials");
			session.setAttribute("loginMessage","Welcome: " +user.getName());
		}
		else
		{
			mv.addObject("errorMessage"," invalid credentials");
		}
		return mv;
	}
	@RequestMapping("/Logout")
	public ModelAndView Logout()
	{
		ModelAndView mv = new ModelAndView("/Home");
		//session.invalidate();								//to remove all the values from the session
		session.removeAttribute("loginMessage");			//to remove only particular value
		return mv;
	}
	@RequestMapping("/Home")
	public ModelAndView showHome1Page()
	{
		System.out.println("clicked on login");
		ModelAndView mv = new ModelAndView("/Home");
		
		return mv;
		
	}
		
}
