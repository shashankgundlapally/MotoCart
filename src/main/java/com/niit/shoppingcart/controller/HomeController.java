
package com.niit.shoppingcart.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
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
	private UserDAO userDAO;

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

	// Navigating to a specific page statically
	@RequestMapping("/")
	public ModelAndView onLoad() {
		log.debug("Starting of the method onLoad");
		// specifying which page to navigate
		ModelAndView mv = new ModelAndView("Home");

		session.setAttribute("category", category); // domain object names
		session.setAttribute("product", product);
		session.setAttribute("supplier", supplier);
		session.setAttribute("user", user);

		session.setAttribute("categoryList", categoryDAO.getAllCategories());

		session.setAttribute("supplierList", supplierDAO.getAllSuppliers());

		session.setAttribute("productList", productDAO.getAllProducts());
		mv.addObject("Clickedcatproduct","true");
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
	public ModelAndView showRegisterPage(Model model) {
		log.debug("Starting of method showRegisterPage");
		ModelAndView mv = new ModelAndView("/Registration");
		mv.addObject("user", user);
		mv.addObject("isUserClickedRegistration", "true");
		model.addAttribute("regsuccess", "u have successfully registered.plz login to enjoy our sevices");
		log.debug("Ending of the method showRegistrationPage");
		return mv;
	}

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

		mv.addObject("Clickedcatproduct","true");
		return mv;

	}


	@RequestMapping("/userdetails")
	public ModelAndView showUserPage(@ModelAttribute("user") User user, HttpSession session, Model model) {
		log.debug("Starting of the method showUserPage");
		ModelAndView mv = new ModelAndView("/userdetails");
		/* mv.addObject("userList",userDAO.getAllUsers()); */
		/*
		 * session.setAttribute("userdetails", userDAO.getUserByName((String)
		 * session.getAttribute("name")));
		 * mv.addObject("userdetails",userDAO.getUserByName(name));
		 */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username
		session.setAttribute("userList", userDAO.getUserByName(name));
		session.setAttribute("contact", user.getContact());
		model.addAttribute("username", name);
		System.err.println("username++++++++++++++++++++++++++++++++++" + name);
		mv.addObject("isUserClickedUserdetails", "true");
		log.debug("Ending of the method showUserPage");
		return mv;

	}

	@RequestMapping(value = "ShowProduct/{id}")
	public String ShowProduct(@PathVariable("id") int id, RedirectAttributes attributes, Model m) {
		m.addAttribute("UserClickedshowproduct", "true");
		m.addAttribute("IndividualProduct", productDAO.getproduct(id));
		return "ShowProduct";
	}

	
	  /*@RequestMapping(value="navproducts/{id}") 
	  public String navproduct(Model m,@PathVariable("id") int id ,RedirectAttributes attributes)
	  {
	  	  m.addAttribute("navproducts", productDAO.navproduct(id));
		  log.debug("nave method staret..............!"+id);
	  attributes.addFlashAttribute("navproducts", productDAO.navproduct(id));
	  log.debug("nave method ending..............!" + productDAO.navproduct(id));
	  return "redirect:/"; 
	  }*/
	 
	@RequestMapping(value = "navproducts/{id}")
	public String navproduct(Model m, @PathVariable("id") int id) {
		log.debug("nave method staret..............!"+id);
		m.addAttribute("Clickedcatproduct", "true");
		m.addAttribute("navproducts", productDAO.navproduct(id));
		log.debug("nave method ending..............!" + productDAO.navproduct(id));
		return "catproducts";
	}
}