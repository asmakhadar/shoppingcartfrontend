package com.niit.shoppingcart.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.util.Util;


@Controller
public class ProductController 
{

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	Product product;
	
	private Path path;
	
	@RequestMapping("/product")
	public String showRegistrationPage(Model m)
	{
		m.addAttribute("product", new Product());
		
		m.addAttribute("supplier", new Supplier());
        m.addAttribute("category", new Category());
		
		m.addAttribute("supplierList", this.supplierDAO.list() );
		m.addAttribute("categoryList", this.categoryDAO.list());
		m.addAttribute("productList", this.productDAO.list());
		
	//mv.addObject("msg","you clicked registration link");
//		mv.addObject("showRegistrationPage","true");
		return "product";
	}	
	
	@RequestMapping(value="add_product", method = RequestMethod.POST)
	public String addproduct(Model model, @Valid @ModelAttribute("product")Product product,HttpServletRequest request)
	{
	   Category category=categoryDAO.getByName(product.getCategory().getName());
	   
	   Supplier supplier=supplierDAO.getByName(product.getSupplier().getName());
	   product.setCategory(category);
	   product.setSupplier(supplier);
	   
	   product.setCategory_id(category.getId());
	   product.setSupplier_id(supplier.getId());
	   
	    Util util = new Util();
		String product_id = util.removeComma(product.getId());
		product.setId(product_id);
		productDAO.save(product);
		MultipartFile file = product.getImage();
		System.out.println(product.getImage());
     	String rootDirectory=request.getSession().getServletContext().getRealPath("/");
     	System.out.println(rootDirectory);
		path =Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\"+product.getId()+".jpg");
		if(file!=null && !file.isEmpty())
		{
			try{
				file.transferTo(new File(path.toString()));
				System.out.println("image uploaded....");
			}
		catch(Exception e)
		{
		e.printStackTrace();
		throw new RuntimeException("image saving failed",e);
		}
		}

		
		System.out.println("Product added.");
		return "redirect:/product";
	}
	
	@Transactional
	@RequestMapping("product_delete-{id}")
	public String deleteproduct (@PathVariable("id")String id)
	{
		productDAO.delete(id);
		System.out.println("product deleted");
		return "redirect:/product";
	}

	@Transactional
	@RequestMapping("product_edit-{id}")
	public String editproduct (@PathVariable("id") String id,Model model)
	{
		model.addAttribute("product", this.productDAO.get(id));
		model.addAttribute("productList", productDAO.list());
		System.out.println("product edited");
	    return "product";
	}
	@RequestMapping(value="/product_get_{id}")
	public String viewProduct(@PathVariable("id")String id,Model model)
	{
		model.addAttribute("selectedProduct", this.productDAO.get(id));
		System.out.println("product added");
		return "item";
	}
}
