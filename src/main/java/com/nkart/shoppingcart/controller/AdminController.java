package com.nkart.shoppingcart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nkart.shoppingcart.dao.CategoryDAO;
import com.nkart.shoppingcart.dao.ProductDAO;
import com.nkart.shoppingcart.dao.SupplierDAO;
import com.nkart.shoppingcart.domain.Category;
import com.nkart.shoppingcart.domain.Product;
import com.nkart.shoppingcart.domain.Supplier;

@Controller
public class AdminController {

	private static Logger log = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	Category category;
	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	Supplier supplier;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	Product product;

	// define 3 methods
	@RequestMapping("manage_Category")
	public ModelAndView manageCategories(@ModelAttribute("category") Category category, BindingResult result,
			Model model) {
		log.debug("Starting of the method manageCategories");
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		// to access category domain object in category.jsp
		mv.addObject("Category", category);
		mv.addObject("isAdminClickedCategories", "true");

		// get the categories from DB

		mv.addObject("categoryList", categoryDAO.getAllCategories());
		log.debug("Ending of the method manageCategory");

		return mv;

	}

	@RequestMapping("/manage_Products")
	public ModelAndView manageProducts() {

		log.debug("Starting of the method manageProducts");

		ModelAndView modelAndView = new ModelAndView("/Admin/AdminHome");

		modelAndView.addObject("isAdminClickedProducts", "true");

		modelAndView.addObject("product", product);
		modelAndView.addObject("productList", productDAO.getAllProducts());

	
		
		modelAndView.addObject("category", category);
		modelAndView.addObject("categoryList", categoryDAO.getAllCategories());

		modelAndView.addObject("supplier", supplier);
		modelAndView.addObject("supplierList", supplierDAO.getAllSuppliers());

		log.debug("Ending of the method manageProducts");
		return modelAndView;
	}
	
	@RequestMapping("/manage_ProductsEdit")
	public ModelAndView manageProductsEdit() {

		log.debug("Starting of the method manageProducts");

		ModelAndView modelAndView = new ModelAndView("/Admin/AdminHome");

		modelAndView.addObject("isAdminClickedProducts", "true");

		
		modelAndView.addObject("productList", productDAO.getAllProducts());

		modelAndView.addObject("category", category);
		modelAndView.addObject("categoryList", categoryDAO.getAllCategories());

		modelAndView.addObject("supplier", supplier);
		modelAndView.addObject("supplierList", supplierDAO.getAllSuppliers());

		log.debug("Ending of the method manageProducts");
		return modelAndView;
	}
	
	@RequestMapping("/manage_Suppliers")
	public ModelAndView manageSuppliers(@ModelAttribute("supplier")Supplier supplier,BindingResult result,Model model) {
		
		log.debug("Starting of the method manageSuppliers");
		
		ModelAndView modelAndView = new ModelAndView("/Admin/AdminHome");

		modelAndView.addObject("isAdminClickedSuppliers", "true");

		modelAndView.addObject("supplierList", supplierDAO.getAllSuppliers());
		//modelAndView.addObject("supplier", supplier);

		log.debug("Ending of the method manageSuppliers");
		return modelAndView;
	}
	@RequestMapping("/AdminHome")
	public ModelAndView showAdminHomePage() {
		System.out.println("clicked on login");
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		mv.addObject("isClickedAdminHome", true);
		return mv;

	}
}
