package com.nkart.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nkart.shoppingcart.dao.CategoryDAO;
import com.nkart.shoppingcart.domain.Category;

@Controller
public class CategoryController
{
	//Category.jsp - addCategory,delete,update,showCategoryList
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	//CRUD operations
	
	@PostMapping("/create_category")
	public ModelAndView createCategory(@RequestParam("Category ID")String id,@RequestParam("Category Name") String name,@RequestParam("Description")String description)
	{
		category.setId(id);
		category.setName(name);
		category.setDescription(description);
		
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		if (categoryDAO.createCategory(category))
		{
			mv.addObject("message", "successfully created category");
		}
		else
		{
			mv.addObject("message", "not able to create category!! contact Admin");
		}
		return mv;
	}
	
	@GetMapping("/Delete_Category/{id}")
	public ModelAndView deleteCategory(@PathVariable("Category ID")String id)
	{
		category.setId(id);
		
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		if(categoryDAO.deleteCategory(category))
		{
			mv.addObject("message", "successfully deleted category");
		}
		else
		{
			mv.addObject("message", "category not deleted");
		}
		return mv;
	}
}
