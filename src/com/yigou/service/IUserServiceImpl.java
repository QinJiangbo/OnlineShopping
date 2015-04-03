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
public class IUserServiceImpl implements IUserService {
	IDbHelperImpl data=new IDbHelperImpl();
	@Override
	public boolean login(String userEmail, String password) {
		String sql="select count(*) n from user where u_email=? and u_password=?";
		Object[] params={userEmail,password};
		Map row=data.runSelect(sql,params)[0];
		int n=Integer.parseInt(row.get("n").toString());
		return n==1;
	}

	@Override
	public boolean checkUser(String email) {
		String sql="select count(*) i from user where u_email=?";
		Object[] params={email};
		
		Map row=data.runSelect(sql, params)[0];
		int i=Integer.parseInt(row.get("i").toString());
		return i<1;
	}

	@Override
	public void register(int id, String userName, String sex, String password,
			String email, String telephone, String QQ, String address,String date) {
		String sql="insert into user(u_name,u_sex,u_password,u_email,u_telephone,u_QQ,u_address,u_date) values(?,?,?,?,?,?,?,current_Date())";
		Object[] params={userName,sex,password,email,telephone,QQ,address};
		data.runUpdate(sql, params);
	}

	@Override
	public Map userInfo(String userEmail) {
		String sql="select * from user where u_email=?";
		Object[] param={userEmail};
		Map row=this.data.runSelect(sql, param)[0];
		return row;
	}

	@Override
	public void addFeedback(String userEmail, String Feedback) {
		String sql="insert into feedback(u_email,f_content) values(?,?)";
		Object[] params={userEmail,Feedback};
		this.data.runUpdate(sql, params);
	}

	@Override
	public void modifyUser(String userID, String userName, String userGender,
			String userPassword, String userEmail, String userTelephone,
			String userQQ, String userAddress) {
		String sql="update user set u_name='"+userName+"',u_sex='"+userGender+"',u_password='"+userPassword+"',u_email='"+userEmail+"',u_telephone='"+userTelephone+"',u_QQ='"+userQQ+"',u_address='"+userAddress+"' where u_id="+userID+"";
		this.data.runUpdate(sql);
	}
}
