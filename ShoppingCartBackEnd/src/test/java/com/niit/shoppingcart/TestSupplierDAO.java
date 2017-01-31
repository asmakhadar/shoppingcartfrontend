package com.niit.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

public class TestSupplierDAO 
{

	@Autowired
	SupplierDAO supplierDAO;

	@Autowired
	Supplier supplier;

	@Autowired
	AnnotationConfigApplicationContext context;

	public TestSupplierDAO()
	{
		        context = new AnnotationConfigApplicationContext();
		        context.scan("com.niit.shoppingcart");
		        context.refresh();
		        supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		        supplier=(Supplier)context.getBean("supplier");
		
	}
	public void add()
	{
		supplier.setId("06");
		supplier.setName("deeks");
		supplier.setAddress("udupi");
		supplierDAO.save(supplier);
		System.out.println("saved successfully");
	}

	public void update()
	{
		supplier.setId("01");
		supplier.setName("afroz");
		supplier.setAddress("ananthpur");
		supplierDAO.update(supplier);
		System.out.println("successfully updated");	
	}

	//public void delete()
	//{
//		Scanner sc=new Scanner(System.in);   // instead of scanner class we can use
//		System.out.println("enter ID");      //user=userDAO.getuser();
//		String id=sc.next();                 //
//		userDAO.delete(id);
//		System.out.println("deleted successfully");
	//}

	public void getSupplier()
	{
		supplier=supplierDAO.get("01");
		System.out.println(supplier.getAddress());
	}

	public static void main(String[] args) 
	{
	TestSupplierDAO ts =new TestSupplierDAO();
	
	//ts.add();
	//ts.delete();
	ts.update();
	//ts.getSupplier();
	}		
	}

