package com.niit.shoppingcart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;



@Controller
public class SupplierController {
	
	private static Logger log = LoggerFactory.getLogger(SupplierController.class);

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier supplier;
	
	


	@RequestMapping(value = "/manage_create_supplier", method = RequestMethod.POST)
	public String createSupplier(@ModelAttribute("supplier") Supplier supplier, Model model) {

		log.debug(" Starting of the method createSupplier");
		log.info("id:" + supplier.getId());
		
		if (supplierDAO.createSupplier(supplier) == true) {
			
			model.addAttribute("Message", "Successfully created supplier");
		} 
		else 
		{
			model.addAttribute("Message", "Supplier Not Created");
		}
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", supplierDAO.getAllSuppliers());
		model.addAttribute("isAdminClickedSupplier", "true");
		
		log.debug(" Ending of the method createSupplier");
		return "forward:/manage_Suppliers";
	}

	@RequestMapping("/manage_Delete_Supplier/{id}")
	public String deleteSupplier(@PathVariable("id") int id, Model model) throws Exception{

		log.debug("Starting of the method deleteSupplier");
		supplier.setId(id);
		boolean flag = supplierDAO.deleteSupplier(supplier);

		String msg = "Successfully deleted the supplier";
		
		if (flag != true) 
		{
			msg = "Not able to delete the supplier";
		}
		model.addAttribute("Message", msg);
		
		log.debug("Ending of the method deleteSupplier");
		return "forward:/manage_Suppliers";
	}

	@RequestMapping(value="/manage_Edit_Supplier/{id}", method = RequestMethod.GET)
	public String editSupplier(@PathVariable("id") int id,RedirectAttributes attributes) {
			supplier.setId(id);	
           attributes.addFlashAttribute("supplier", this.supplierDAO.getSupplierById(id));
		
	
		return "redirect:/manage_Suppliers";
	}
	
	@RequestMapping(value="/manage_Update_supplier")
	public String updateCategory(@ModelAttribute("supplier") Supplier supplier)
	{
		
		supplierDAO.updateSupplier(supplier);
		return "redirect:/manage_Suppliers";
	
	}
}