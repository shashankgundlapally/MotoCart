package com.nkart.shoppingcart.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nkart.shoppingcart.dao.CartDAO;
import com.nkart.shoppingcart.dao.CategoryDAO;
import com.nkart.shoppingcart.dao.ProductDAO;
import com.nkart.shoppingcart.dao.SupplierDAO;
import com.nkart.shoppingcart.dao.UserDAO;
import com.nkart.shoppingcart.domain.Cart;
import com.nkart.shoppingcart.domain.Category;
import com.nkart.shoppingcart.domain.Product;
import com.nkart.shoppingcart.domain.Supplier;
import com.nkart.shoppingcart.domain.User;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
public class SpringController {

	public static Logger log = LoggerFactory.getLogger(SpringController.class);

	
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private Cart cart;

	@Autowired
	private HttpSession session;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier supplier;

	@Autowired
	private Product product;

	@Autowired
	private ProductDAO productDAO;

	// authentication-failure-forward-url="/loginError"
	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(Model model) {
		log.debug("Starting of the method loginError");
		model.addAttribute("errorMessage", "Invalid Credentials.  Please try again.");
		model.addAttribute("invalidCredentials", "true");
		log.debug("Ending of the method loginError");
		return "Home";

	}

	// <security:access-denied-handler error-page="/accessDenied" />
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied(Model model) {
		log.debug("Starting of the method accessDenied");
		model.addAttribute("errorMessage", "You are not authorized to access this page");

		log.debug("Ending of the method accessDenied");
		return "Home";

	}

	// <security:form-login authentication-success-forward-url="/success"/>
	/*
	 * @RequestMapping("/success") public ModelAndView successForwardURL() {
	 * log.debug("Starting of the method successForwardURL"); ModelAndView mv =
	 * new ModelAndView("home");
	 * 
	 * Authentication auth =
	 * SecurityContextHolder.getContext().getAuthentication(); String
	 * loggedInUserid = auth.getName(); Collection<GrantedAuthority> authorities
	 * = (Collection<GrantedAuthority>) auth.getAuthorities(); if
	 * (authorities.contains("ROLE_ADMIN")) { mv.addObject("isAdmin", "true");
	 * log.debug("You are Admin"); } else { log.debug("You are not  Admin");
	 * mv.addObject("isAdmin", "false"); // myCart = cartDAO.list(userID);
	 * mv.addObject("myCart", myCart); // Fetch the myCart list based on user ID
	 * List<MyCart> cartList = cartDAO.list(loggedInUserid);
	 * mv.addObject("cartList", cartList); mv.addObject("cartSize",
	 * cartList.size()); }
	 * 
	 * log.debug("Ending of the method successForwardURL"); return mv;
	 * 
	 * }
	 */
	/**
	 * If we are using spring-security, this method is going to execute after
	 * login
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login_session_attributes")
	public String login_session_attributes(HttpSession session,Model model) {
		
		log.info("Starting of the method loggin...!");
		System.err.println("validate function....................!");
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		System.err.println(username);
		User user = userDAO.getUserByName(username);
		System.err.println(user.getId());
		session.setAttribute("userid", user.getId());
		session.setAttribute("name", user.getName());
		session.setAttribute("LoggedIn", "true");

		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		String role="ROLE_USER";
		for (GrantedAuthority authority : authorities) 
		{
		  
		     if (authority.getAuthority().equals(role)) 
		     {
		    	 session.setAttribute("UserLoggedIn", "true");
		    	
		    	 return "redirect:/";
		     }
		     else 
		     {
		    	 session.setAttribute("isUserClickedAdminHome", "true");
		    	model.addAttribute("product",  new Product());
		    	 
			 return "/Admin/AdminHome";
		     }
	}
		return "/Home";
	}
	/*public ModelAndView validate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("starting of the method validate");
		ModelAndView mv = new ModelAndView("Home");
		// session = request.getSession(true);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userID = auth.getName();
		session.setAttribute("loggedInUser", userID);
		System.err.println(request.isUserInRole("admin"));
		if (request.isUserInRole("admin")) {
			

			session.setAttribute("isAdmin", true);

		} else {

			session.setAttribute("isAdmin", false);

			mv.addObject("cart", cart);
			// Fetch the myCart list based on user ID
			List<Cart> cartList = cartDAO.getAllCarts(userID);
			mv.addObject("cartList", cartList);
			mv.addObject("cartSize", cartList.size());
			mv.addObject("totalAmount", cartDAO.getTotalAmount(userID));

		}
		log.debug("Ending of the method validate");
		return mv;
	}*/

	@RequestMapping("/perform_logout")
	public ModelAndView secureLogout() {
		// what you attach to session at the time login need to remove.
        System.out.println("i am in ogout");
		session.invalidate();

		ModelAndView mv = new ModelAndView("Home");

		// After logout also use should able to browse the categories and
		// products
		// as we invalidated the session, need to load these data again.

		session.setAttribute("category", category); 
		session.setAttribute("product", product);
		session.setAttribute("supplier", supplier);

		session.setAttribute("categoryList", categoryDAO.getAllCategories());

		session.setAttribute("supplierList", supplierDAO.getAllSuppliers());

		session.setAttribute("productList", productDAO.getAllProducts());

		// OR Simpley remove only one attribute from the session.

		// session.removeAttribute("loggedInUser"); // you no need to load
		// categoriees,suppliers and products

		return mv;

	}

}
