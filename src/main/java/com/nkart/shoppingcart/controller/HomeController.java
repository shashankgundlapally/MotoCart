package com.nkart.shoppingcart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nkart.shoppingcart.dao.CategoryDAO;
import com.nkart.shoppingcart.dao.ProductDAO;
import com.nkart.shoppingcart.dao.SupplierDAO;
import com.nkart.shoppingcart.dao.UserDAO;
import com.nkart.shoppingcart.domain.Category;
import com.nkart.shoppingcart.domain.Product;
import com.nkart.shoppingcart.domain.Supplier;
import com.nkart.shoppingcart.domain.User;

@Controller
public class HomeController 
{
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private User user;
	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Category category;
	@Autowired
	private Product product;
	@Autowired
	private Supplier supplier;
	
	
	
	
	@Autowired
	private HttpSession session;
	
	/* http://localhost:8080/nkart/ */
	
	//Navigating to a specific page statically
	@RequestMapping("/")
public ModelAndView onLoad()
{
		
		//specifying which page to navigate
	ModelAndView mv = new ModelAndView("/Home");
	
	session.setAttribute("category", category); // domain object names
	session.setAttribute("product", product);
	session.setAttribute("supplier", supplier);
	
	
	session.setAttribute("categoryList", categoryDAO.getAllCategories());
	
	session.setAttribute("supplierList", supplierDAO.getAllSuppliers());
	
	session.setAttribute("productList", productDAO.getAllProducts());
	/*session.setAttribute("category", arg1);*/
	
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
/*	@PostMapping("/validate")  //used for post method
	public ModelAndView validateCredentials(@RequestParam("userID") String id,@RequestParam("password") String password)
	{
		ModelAndView mv = new ModelAndView("/Home");
		user = userDAO.validate(id, pwd);  //you no need to do this step if you are using spring security
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
	
	
@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public ModelAndView validate(@RequestParam(value = "username") String userID,
			@RequestParam(value = "password") String password) {
		log.debug("Starting of the method validate");

		// ModelAndView mv = new ModelAndView("/home");
		ModelAndView mv = new ModelAndView("/home");
		user = userDAO.isValidUser(userID, password);  //you no need to do this step 
											//if you are using spring security
		// if the record exist with this userID and password it will return user
		// details else will return null

		if (user != null) {
			log.debug("Valid Credentials");
			
			session.setAttribute("loggedInUser", user.getName());
			session.setAttribute("loggedInUserID", user.getId());

			session.setAttribute("user", user); //
			session.setAttribute("supplier", supplier);
			session.setAttribute("supplierList", supplierDAO.list());
			
			session.setAttribute("productList", productDAO.list());
			session.setAttribute("product", product);

			session.setAttribute("category", category);
			session.setAttribute("categoryList", categoryDAO.list());

			if (user.getRole().equals("ROLE_ADMIN")) {
				log.debug("Logged in as Admin");
				mv.addObject("isAdmin", "true");
				

			} else {
				log.debug("Logged in as User");
				mv.addObject("isAdmin", "false");
				//myCart = cartDAO.list(userID);
				mv.addObject("myCart", myCart);
				// Fetch the myCart list based on user ID
				List<MyCart> cartList = cartDAO.list(userID);
				mv.addObject("cartList", cartList);
				mv.addObject("cartSize", cartList.size());
			}

		} else {
			log.debug("Invalid Credentials");

			mv.addObject("invalidCredentials", "true");
			mv.addObject("errorMessage", "Invalid Credentials");
			
			// ${errorMessage}

		}
		log.debug("Ending of the method validate");
		return mv;
	}*/
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
	@RequestMapping("/cart")
	public ModelAndView showCartPage()
	{
		System.out.println("clicked on cart");
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserClickedCart", "true");
		
		return mv;
		
	}
		
}
