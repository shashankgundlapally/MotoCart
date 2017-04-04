package com.niit.shoppingcart.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

@Controller
public class ProductController {
	private static Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private Product product;
	
	private Path path;

	@PostMapping("/manage_create_product")
	public String createProduct(@ModelAttribute("product") Product product, HttpServletRequest request,Model model) {
		log.debug(" Starting of the method createProduct");
		
		if (productDAO.createProduct(product) == true) {
			model.addAttribute("Message", "Successfully Created the Product");
		
		} else {
			model.addAttribute("Message", "Product Not Created");
		}
		
		
		
		MultipartFile file=product.getImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		System.out.println("Root: "+rootDirectory);
        path = Paths.get(rootDirectory + "resources/images/"+product.getId()+".jpg");
        if (file != null && !file.isEmpty()) {
            try {
            	System.out.println("Image Saving Start");
            	file.transferTo(new File(path.toString()));
            	System.out.println("Image Saved");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error");
                throw new RuntimeException("item image saving failed.", e);
            }
        }
		model.addAttribute("product", product);
		
		model.addAttribute("productList", productDAO.getAllProducts());
		model.addAttribute("isAdminClickedProduct", "true");

		log.debug(" Ending of the method createProduct");
		return "forward:/manage_Products";
	}

	@RequestMapping("/manage_Delete_Product/{id}")
	public String deleteProduct(@PathVariable("id") int id, Model model) throws Exception {
		log.debug("Starting of the method deleteProduct");
		product.setId(id);
		boolean flag = productDAO.deleteProduct(product);

		String msg = "Successfully deleted the product";

		if (flag != true) {
			msg = "Not able to delete the product";
		}
		model.addAttribute("Message", msg);

		log.debug("Ending of the method deleteProduct");
		return "redirect:/manage_Products";
	}

	@GetMapping("/manage_Edit_Product/{id}")
	public String editProduct(@PathVariable("id") int id, Model model,RedirectAttributes attributes) {
		log.debug("Starting of the method editProduct");
		attributes.addFlashAttribute("product", this.productDAO.getProductById(id));
		log.debug("Ending of the method editProduct");
		return "redirect:/manage_ProductsEdit";
	}
	
	@RequestMapping(value="/manage_Update_product")
	public String updateCategory(@ModelAttribute("product") Product product,HttpServletRequest request)
	{
		
		productDAO.updateProduct(product);
		MultipartFile file=product.getImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "resources/images/"+product.getId()+".jpg");
        if (file != null && !file.isEmpty()) {
            try {
            	System.out.println("Image Saving Start");
            	file.transferTo(new File(path.toString()));
            	System.out.println("Image Saved");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error");
                throw new RuntimeException("item image saving failed.", e);
            }
        }
		return "redirect:/manage_Products";
	
	}
}
