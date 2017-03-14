package com.nkart.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nkart.shoppingcart.dao.SupplierDAO;
import com.nkart.shoppingcart.domain.Supplier;

@Controller
public class SupplierController 
{

	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private Supplier supplier;
	
	public ModelAndView createSupplier(@RequestParam("Supplier ID")String id,@RequestParam("Supplier Name")String name,@RequestParam("Address")String address)
	{
		supplier.setId(id);
		supplier.setName(name);
		supplier.setAddress(address);
		
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		
			if (supplierDAO.createSupplier(supplier))
			{
				mv.addObject("message", "successfully created Supplier");
			}
			else
			{
				mv.addObject("message", "not able to create Supplier!! contact Admin");
			}
			return mv;
		
	}
}
