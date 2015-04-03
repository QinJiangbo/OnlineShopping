package com.yigou.dao;

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
public interface IDbHelper {

	//run the select SQL with parameters
	public Map[] runSelect(String sql,Object[] params);
	//run the select SQL without parameters
	public Map[] runSelect(String sql);
	//run the update SQL without parameters
	public void runUpdate(String sql);
	//run the update SQL with parameters
	public void runUpdate(String sql,Object[] params);
}
