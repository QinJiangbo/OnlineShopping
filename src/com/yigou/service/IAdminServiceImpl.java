package com.yigou.service;

import java.util.Map;

import com.yigou.dao.IDbHelperImpl;

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
public class IAdminServiceImpl implements IAdminService{

	IDbHelperImpl data=new IDbHelperImpl();
	@Override
	public boolean login(String adminName, String password) {
		String sql="select count(*) n from admin where a_name=? and a_password=?";
		Object[] params={adminName,password};
		Map row=data.runSelect(sql,params)[0];
		int n=Integer.parseInt(row.get("n").toString());
		return n==1;
	}
	
	@Override
	public boolean checkAdmin(String adminName) {
		String sql="select count(*) i from admin where a_name=?";
		Object[] params={adminName};
		Map row=data.runSelect(sql, params)[0];
		int i=Integer.parseInt(row.get("i").toString());
		return i<1;
	}

	@Override
	public Map[] showUser() {
		String sql="select * from user";
		Map[] rows=this.data.runSelect(sql);
		return rows;
	}

	@Override
	public void deleteUser(String userEmail) {
		String sql="delete from user where u_email=?";
		Object[] params={userEmail};
		this.data.runUpdate(sql, params);
	}

	@Override
	public Map[] showProducts() {
		String sql="select * from product";
		Map[] rows=this.data.runSelect(sql);
		return rows;
	}

	@Override
	public void deleteProduct(String productID) {
		String sql="delete from product where p_id=?";
		Object[] params={productID};
		this.data.runUpdate(sql, params);
	}

	@Override
	public Map[] showFeedback() {
		String sql="select * from feedback";
		Map[] rows=this.data.runSelect(sql);
		return rows;
	}

	@Override
	public void deleteFeedback(String feedbackID) {
		String sql="delete from feedback where f_id=?";
		Object[] params={feedbackID};
		this.data.runUpdate(sql, params);
	}

	@Override
	public void modifyProduct(String productID,String productType, String productName,
			String productPrice, String productQuantity, String productImage,
			String productDescription, String productTime) {
		String sql="update product set p_type='"+productType+"',p_name='"+productName+"',p_price='"+productPrice+"',p_quantity='"+productQuantity+"',p_image='"+productImage+"',p_description='"+productDescription+"',p_time='"+productTime+"'where p_id="+productID+"";
		this.data.runUpdate(sql);
	}

	@Override
	public Map[] showAdmin() {
		String sql="select * from admin";
		Map[] rows=this.data.runSelect(sql);
		return rows;
	}

	@Override
	public void deleteAdmin(String adminID) {
		String sql="delete from admin where a_id=?";
		Object[] params={adminID};
		this.data.runUpdate(sql, params);
		
	}

	@Override
	public void addAdmin(String adminName, String password, String adminQQ,String adminLevel) {
		String sql="insert into admin(a_name,a_password,a_QQ,a_date,a_level) values(?,?,?,current_date(),?)";
		Object[] params={adminName,password,adminQQ,adminLevel};
		this.data.runUpdate(sql, params);
		
	}
}
