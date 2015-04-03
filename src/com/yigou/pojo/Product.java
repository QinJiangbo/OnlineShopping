package com.yigou.pojo;

/*
 * Author by QinJiangbo 2012302580314
 * 
 *  Date 2014-05-24
 *  
 *  All Rights Reseverd
 *  
 *   Copy is never allowed!
 * */

public class Product {
	private String type;
	private int id;
	private String name;
	private double price;
	private int quantity;
	private String image;
	private String description;
	private String time;
	
	//construction without parameters
	public Product(){
		
	}
	
	//construction with parameters
	public Product(String type, int id, String name, double price,
			int quantity, String image, String description, String time) {
		super();
		this.type = type;
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.description = description;
		this.time = time;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
