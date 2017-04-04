
package com.niit.shoppingcart.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.shoppingcart.domain.User;

@Controller
public class HomeController {
	Logger log = LoggerFactory.getLogger(HomeController.class);
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

	/* http://localhost:8080/Moto Cart/ */

	// Navigating to a specific page statically
	@RequestMapping("/")
	public ModelAndView onLoad() {
		log.debug("Starting of the method onLoad");
		// specifying which page to navigate
		ModelAndView mv = new ModelAndView("Home");

		session.setAttribute("category", category); // domain object names
		session.setAttribute("product", product);
		session.setAttribute("supplier", supplier);
		session.setAttribute("user", new User());

		session.setAttribute("categoryList", categoryDAO.getAllCategories());

		session.setAttribute("supplierList", supplierDAO.getAllSuppliers());

		session.setAttribute("productList", productDAO.getAllProducts());
		log.debug("Ending of the method onLoad");

		return mv;
	}

	@RequestMapping("/Login")
	public ModelAndView showLoginPage() {
		log.debug("Starting of the method showLoginPage");
		ModelAndView mv = new ModelAndView("/Login");
		mv.addObject("user", user);
		mv.addObject("isUserClickedLogin", "true");
		log.debug("Ending of the method showLoginPage");
		return mv;

	}

	@RequestMapping("/Registration")
	public ModelAndView showRegisterPage() {
		log.debug("Starting of method showRegisterPage");
		ModelAndView mv = new ModelAndView("/Registration");
		mv.addObject("user", user);
		mv.addObject("isUserClickedRegistration", "true");
		log.debug("Ending of the method showRegistrationPage");
		return mv;
	}
		
	/*@RequestMapping("/Logout")
	public ModelAndView Logout() {
		System.err.println("normal login????????????");
		ModelAndView mv = new ModelAndView("/Home");
		// session.invalidate(); //to remove all the values from the session
		session.removeAttribute("loginMessage"); // to remove only particular
													// value
		return mv;
	}*/

	@RequestMapping("/Home")
	public ModelAndView showHome1Page() {
		
		ModelAndView mv = new ModelAndView("/Home");
		session.setAttribute("category", category); // domain object names
		session.setAttribute("product", product);
		session.setAttribute("supplier", supplier);
		session.setAttribute("user", new User());

		session.setAttribute("categoryList", categoryDAO.getAllCategories());

		session.setAttribute("supplierList", supplierDAO.getAllSuppliers());

		session.setAttribute("productList", productDAO.getAllProducts());

		return mv;

	}

	@RequestMapping("/cart")
	public ModelAndView showCartPage() {
		log.debug("Starting of the method showCartPage");
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserClickedCart", "true");
		log.debug("Ending of the method showCartPage");
		return mv;

	}
}
