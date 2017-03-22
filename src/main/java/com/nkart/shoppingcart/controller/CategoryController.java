package com.nkart.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@PostMapping("/manage_create_category")
	public String createCategory(@RequestParam("id")String id,@RequestParam("name") String name,@RequestParam("description")String description, Model model)
	{
		category.setId(id);
		category.setName(name);
		category.setDescription(description);
		categoryDAO.createCategory(category);
		
		
		/*ModelAndView mv = new ModelAndView("forward:/Category");
		if (categoryDAO.createCategory(category))
		{
			mv.addObject("message", "successfully created category");
		}
		else
		{
			mv.addObject("message", "not able to create category!! contact Admin");
		}*/
		model.addAttribute("category", category);
		model.addAttribute("categoryList", categoryDAO.getAllCategories());
		model.addAttribute("isAdminClickedCategories", "true");
		return "redirect:/manage_Category";
	}
	/*@RequestMapping(value="/Category")
	public ModelAndView getAllData(@ModelAttribute("category")Category category,BindingResult result,Model model)
	{
		ModelAndView mv=new ModelAndView("forward:/Category");
	mv.addObject("categoryList",categoryDAO.list());
	mv.addObject("isUserClickedCategories","true");
		return mv;
	}*/
	
	@GetMapping("/manage_Delete_Category/{id}")
	public String deleteCategory(@PathVariable("id")String id)
	{
		category.setId(id);
		categoryDAO.deleteCategory(category);
		
		//ModelAndView mv = new ModelAndView("forward:/create_category");
	
		/*if(categoryDAO.deleteCategory(category))
		{
			mv.addObject("message", "successfully deleted category");
		}
		else
		{
			mv.addObject("message", "category not deleted");
		}*/
		return "redirect:/manage_Category";
		
	}
	
	@GetMapping("/manage_Edit_Category/{id}")
	public String editCategory(@PathVariable("id") String id,RedirectAttributes attributes)
	{
		category.setId(id);
		categoryDAO.updateCategory(category);
		/*System.out.println("id"+id);
		ModelAndView mv = new ModelAndView("forward:/Categroy");
		if(categoryDAO.updateCategory(category))
		{
			mv.addObject("message", "successfully updated category ");
		}
		else
		{
			mv.addObject("message", "can't update category!");
		}*/
		return "redirect:/manage_Category";
	}
	
	
}
/*
	@Autowired
	private CategoryDAO categoryDAO;


	@RequestMapping(value="/Category")
	public ModelAndView getAllData(@ModelAttribute("category")Category category,BindingResult result,Model model)
	{
		ModelAndView mv=new ModelAndView("/Admin/AdminHome");
	mv.addObject("categoryList",categoryDAO.list());
	mv.addObject("isUserClickedCategories","true");
		return mv;
	}
	
	
	@RequestMapping(value="/create_category",method = RequestMethod.POST)
   public String addItem(@ModelAttribute("category") Category category){
		
		this.categoryDAO.save(category);
		return "redirect:/Category";
		
	}
	@RequestMapping(value="/Edit_Category/{id}",method = RequestMethod.GET)
	public String editItem(@PathVariable("id") String id, RedirectAttributes attributes) {
		System.out.println("editCategory");
		attributes.addFlashAttribute("category", this.categoryDAO.get(id));
		
		return "redirect:/Category";
	}	
	@RequestMapping(value="/Delete_Category/{id}",method = RequestMethod.GET)
	public String deleteItem(@PathVariable("id") String id)
	{
		categoryDAO.delete(id);
		return "redirect:/Category";
	}

}*/