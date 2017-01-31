package com.niit.shoppingcart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.util.Util;

@Controller

public class SupplierController 
{
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	Supplier supplier;
	
	@RequestMapping("/supplier")
	public ModelAndView showRegistrationPage(Model m)
	{
		m.addAttribute("supplier", new Supplier());
		ModelAndView mv = new ModelAndView("supplier");
		mv.addObject("supplierList", supplierDAO.list());
//		mv.addObject("msg","you clicked registration link");
//		mv.addObject("showRegistrationPage","true");
		return mv;
	}	
	
	@RequestMapping(value="add_supplier", method = RequestMethod.POST)
	public String addsupplier(Model model, @Valid @ModelAttribute("supplier")Supplier supplier)
	{
		Util util = new Util();
		String supplier_id = util.removeComma(supplier.getId());
		supplier.setId(supplier_id);
		supplierDAO.save(supplier);
		System.out.println("Supplier added.");
		return "redirect:/supplier";
	}
	@Transactional
	@RequestMapping("supplier_delete-{id}")
	public String deletesupplier (@PathVariable("id")String id)
	{
		supplierDAO.delete(id);
		System.out.println("supplier deleted");
		return "redirect:/supplier";
	}

	@Transactional
	@RequestMapping("supplier_edit-{id}")
	public String editsupplier (@PathVariable("id") String id,Model model)
	{
		model.addAttribute("supplier", this.supplierDAO.get(id));
		model.addAttribute("supplierList", supplierDAO.list());
		System.out.println("supplier edited");
	    return "supplier";
	}
}
