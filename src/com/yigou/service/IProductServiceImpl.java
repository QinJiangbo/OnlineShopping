package com.yigou.service;

import java.util.Map;

import com.yigou.dao.IDbHelper;
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
public class IProductServiceImpl implements IProductService{
	IDbHelper data=new IDbHelperImpl();

	@Override
	public Map[] query() {
		String sql="select * from product";
		Map[] rows=data.runSelect(sql);
		return rows;
	}

	@Override
	public Map[] Subquery(String Category) {
		String sql="select * from product where p_type=? order by p_id desc limit 8";
		Object[] params={Category};
		Map[] rows=data.runSelect(sql,params);
		return rows;
	}

	@Override
	public Map Details(String productID) {
		String sql="select * from product where p_id=?";
		Object[] params={productID};
		Map row=data.runSelect(sql, params)[0];
		return row;
	}

	@Override
	public Map[] queryProduct(String Category) {
		String sql="select * from product where p_type=? order by p_id desc";
		Object[] params={Category};
		Map[] rows=data.runSelect(sql,params);
		return rows;
	}

	@Override
	public int getRecords() {
		String sql="select count(*) n from product";
		Map row=data.runSelect(sql)[0];
		int n=Integer.parseInt(row.get("n").toString());
		return n;
	}

	@Override
	public Map Details(int productID) {
		String sql="select * from product where p_id=?";
		Object[] params={productID};
		Map row=data.runSelect(sql, params)[0];
		return row;
	}

	@Override
	public void addShoppingCart(String userEmail, String productID) {
		String sql="insert into shoppingcart values(?,?,now())";
		Object[] params={userEmail,productID};
		this.data.runUpdate(sql, params);
	}

	@Override
	public Map[] queryShoppingCart(String userEmail) {
		String sql="select user.u_name,product.*,shoppingcart.buyTime from shoppingcart, product ,user where product.p_id=shoppingcart.p_id and shoppingcart.u_email=user.u_email and shoppingcart.u_email=?";
		Object[] params={userEmail};
		Map[] rows=this.data.runSelect(sql, params);
		return rows;
	}

	@Override
	public void removeProduct(String time) {
		String sql="delete from shoppingcart where buyTime=?";
		Object[] params={time};
		this.data.runUpdate(sql, params);
	}

	@Override
	public Map[] searchProducts(String searchContent) {
		String sql="select * from product where p_id like '%"+searchContent+"%' or p_type like '%"+searchContent+"%' or p_name like '%"+searchContent+"%' or p_price like '%"+searchContent+"%' or p_image like '%"+searchContent+"%' or p_description like '%"+searchContent+"%' or p_time like '%"+searchContent+"%'";
		Map[] rows=this.data.runSelect(sql);
		return rows;
	}

	@Override
	public void emptyShoppingCart(String userEmail) {
		String sql="delete from shoppingcart where u_email=?";
		Object[] params={userEmail};
		this.data.runUpdate(sql, params);
	}

	@Override
	public Map[] showByPage(int page, int pageSize) {
		int preCount=pageSize*(page-1);
		String sql="select * from product limit ?,?";
		Object[] params={preCount,pageSize};
		Map[] rows=data.runSelect(sql,params);
		return rows;
	}

	@Override
	public int getCurrentPage(int pageSize, String productID) {
		String sql="select count(*) n from product where p_id<?";
		Object[] params={productID};
		Map row=data.runSelect(sql,params)[0];
		int n=Integer.parseInt(row.get("n").toString());
		int currentPage=0;
		if (n % pageSize == 0) {
			currentPage = n / pageSize;
		} else {
			currentPage = n / pageSize + 1;
		}
		return currentPage;
	}
	
	
}
