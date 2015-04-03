package com.yigou.service;

import java.util.Map;

/*
 * Author by QinJiangbo 2012302580314
 * 
 *  Date 2014-05-24
 *  
 *  All Rights Reseverd
 *  
 *   Copy is never allowed!
 * */

@SuppressWarnings("rawtypes")
public interface IProductService {
	
	//query the products
	public Map[] query();
	
	//sub-query for each category
	public Map[] Subquery(String Category);
	
	//list the details of a product
	public Map Details(String productID);
	
	//list each kind of product
	public Map[] queryProduct(String Category);
	
	//get the count of the records
	public int getRecords();

	//list the details of a product by page
	public Map Details(int productID);
	
	//add product to shopping cart
	public void addShoppingCart(String userEmail,String productID);
	
	//query products in shopping cart
	public Map[] queryShoppingCart(String userEmail);
	
	//remove the product in the shopping cart
	public void removeProduct(String time);
	
	//search for the product
	public Map[] searchProducts(String searchContent);
	
	//empty the shopping cart
	public void emptyShoppingCart(String userEmail);
	
	//show the products by page
	public Map[] showByPage(int page, int pageSize);
	
	//get current Page
	public int getCurrentPage(int pageSize,String productID);
}
