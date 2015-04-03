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
public interface IAdminService {
	// check the login
	public boolean login(String adminName, String password);

	// check administrator
	public boolean checkAdmin(String adminName);

	// show the users
	public Map[] showUser();

	// delete user
	public void deleteUser(String userEmail);

	// show the products
	public Map[] showProducts();

	// delete product
	public void deleteProduct(String productID);

	// show the products
	public Map[] showFeedback();

	// delete product
	public void deleteFeedback(String feedbackID);
	
	//modify the product
	public void modifyProduct(String productID,String productType,String productName,String productPrice,String productQuantity,String productImage, String productDescription,String productTime);
	
	//show administrators
	public Map[] showAdmin();
	
	//delete administrator
	public void deleteAdmin(String adminID);
	
	//add administrator
	public void addAdmin(String adminName,String password,String adminQQ,String adminLevel);
}
