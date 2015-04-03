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

public interface IUserService {
	//check the login
	public boolean login(String userEmail,String password);
	
	//register the user
	public void register(int id,String userName,String sex,String password,String email,String telephone,String QQ,String address,String date);
	
	//check user
	public boolean checkUser(String email);
	
	//get the information of the user
	@SuppressWarnings("rawtypes")
	public Map userInfo(String userEmail);
	
	//add the feedbacks to the database
	public void addFeedback(String userEmail,String Feedback);
	
	//modify the user account
	public void modifyUser(String userID,String userName,String userGender,String userPassword,String userEmail,String userTelephone,String userQQ,String userAddress);
}
