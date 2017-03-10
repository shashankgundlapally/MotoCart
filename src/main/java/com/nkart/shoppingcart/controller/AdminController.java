package com.nkart.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nkart.shoppingcart.dao.CategoryDAO;
import com.nkart.shoppingcart.dao.ProductDAO;
import com.nkart.shoppingcart.dao.SupplierDAO;
import com.nkart.shoppingcart.domain.Category;
import com.nkart.shoppingcart.domain.Product;
import com.nkart.shoppingcart.domain.Supplier;

@Controller
public class AdminController 
{

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
	
	//define 3 methods
	@RequestMapping("/Categories")
	public ModelAndView manageCategories()
	{
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		mv.addObject("isUserClickedCategories","true");
		
		//get the categories from DB
		
		List<Category> categoryList = categoryDAO.getAllCategories();
		mv.addObject("categoryList", categoryList);
		// to access category domain object in category.jsp
		mv.addObject("category",category);
		System.err.println("Check Error: "+mv);
		
		return mv;
	}
	
	@RequestMapping("/Products")
	public ModelAndView manageProducts()
	{
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		mv.addObject("isUserClickedProducts", "true");
		
		//get the categories from DB
		List<Product> productList = productDAO.getAllProducts();
		mv.addObject("productList", productList);
		mv.addObject("product", product);
		
		return mv;
	}
	
	@RequestMapping("/Suppliers")
	public ModelAndView manageSuppliers()
	{
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		mv.addObject("isUserClickedSuppliers", "true");
		
		//get the categories from DB
		List<Supplier> supplierList = supplierDAO.getAllSuppliers();
		mv.addObject("supplierList", supplierList);
		mv.addObject("supplier",supplier);
		return mv;
	}
	@RequestMapping("/AdminHome")
	public ModelAndView showAdminHomePage()
	{
		System.out.println("clicked on login");
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		mv.addObject("isUserClickedAdminHome", true);
		return mv;
		
	}
}
