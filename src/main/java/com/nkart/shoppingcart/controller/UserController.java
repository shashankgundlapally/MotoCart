package com.nkart.shoppingcart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nkart.shoppingcart.dao.UserDAO;
import com.nkart.shoppingcart.domain.User;

@Controller
public class UserController 
{

	public static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserDAO userDAO;
 
	@RequestMapping(value = "/create_user", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute User user,Model model) {
		log.debug("Starting of the method registerUser");
		/* ModelAndView mv = new ModelAndView("Home");*/
		if (userDAO.getUserById(user.getId()) == null) {
			user.setRole("ROLE_USER"); // all the users are end users by default
			userDAO.createUser(user);
			log.debug("You are successfully register");
			model.addAttribute("successMessage", "You are successfully registered");
			/*mv.addObject("successMessage", "You are successfully registered");*/
		} else {
			log.debug("User exist with this id");
			model.addAttribute("errorMessage", "User exist with this id");
			/*mv.addObject("errorMessage", "User exist with this id");*/
		}
		log.debug("Ending of the method registerUser");
		return "/Home";
	}
	

	
}
