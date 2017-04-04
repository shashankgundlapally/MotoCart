package com.niit.shoppingcart.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Cart;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.User;

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

	private Authentication auth;
	
	
	
	// authentication-failure-forward-url="/loginError"
	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(Model model) {
		log.debug("Starting of the method loginError");
		model.addAttribute("errorMessage", "Invalid Credentials.  Please try again.");
		model.addAttribute("invalidCredentials", "true");
		log.debug("Ending of the method loginError");
		return "Login";
	}

	// <security:access-denied-handler error-page="/accessDenied" />
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied(Model model) {
		log.debug("Starting of the method accessDenied");
		model.addAttribute("errorMessage", "You are not authorized to access this page");

		log.debug("Ending of the method accessDenied");
		return "Home";

	}

	@RequestMapping("/login_session_attributes")
	public String login_session_attributes(HttpSession session, Model model) {

		log.debug("Starting of the method loggin.session.attributes:");
	
		 auth =SecurityContextHolder.getContext().getAuthentication(); 
		String username = auth.getName();
		User user = userDAO.getUserByName(username);
		session.setAttribute("userid", user.getId());
		session.setAttribute("name", user.getName());
		session.setAttribute("LoggedIn", "true");

		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();
		String role = "ROLE_USER";
		
		log.debug("inLoginSession:"+auth.isAuthenticated());
		for (GrantedAuthority authority : authorities) {

			if (authority.getAuthority().equals(role)) {
				session.setAttribute("UserLoggedIn", "true");
		    	 session.setAttribute("cartsize",cartDAO.cartsize((Integer)session.getAttribute("userid")));
		    	 return "redirect:/";
			} else {
				session.setAttribute("isClickedAdminHome", "true");
				model.addAttribute("product", new Product());

				return "/Admin/AdminHome";
			}
		}
		log.debug("Ending of method login_session_attributes: "+auth.isAuthenticated());
		return "/Home";
	}

	@RequestMapping("/perform_logout")
	public ModelAndView performLogout() {
		// what you attach to session at the time login need to remove.
		System.err.println("Perform Logout!!!!!!!!!!!!!!!!!!!!");
		log.debug("inperformlogout:"+auth.isAuthenticated());
		log.debug("Starting of method Logout");
		session.invalidate();

		ModelAndView mv = new ModelAndView("/");

		// After logout also use should able to browse the categories and
		// products
		// as we invalidated the session, need to load these data again.

//		session.setAttribute("category", category);
//		session.setAttribute("product", product);
//		session.setAttribute("supplier", supplier);
//
//		session.setAttribute("categoryList", categoryDAO.getAllCategories());
//
//		session.setAttribute("supplierList", supplierDAO.getAllSuppliers());
//
//		session.setAttribute("productList", productDAO.getAllProducts());

		// OR Simpley remove only one attribute from the session.

		// session.removeAttribute("loggedInUser"); // you no need to load
		// categoriees,suppliers and products
		log.debug("Ending of method performLogout");

		return mv;

	}

}
