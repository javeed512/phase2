package com.simplilearn.ecommerce;

import java.math.BigDecimal;
import java.util.Date;

public class EProduct {  // entity class
	
	private long id;
	private String  name;
	private  BigDecimal price;
	private  Date dop;
	
	
	public EProduct() {
		
		
	}
	
	
	
	public EProduct(long id, String name, BigDecimal price, Date dop) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.dop = dop;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Date getDop() {
		return dop;
	}
	public void setDop(Date dop) {
		this.dop = dop;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", dop=" + dop + "]";
	}
	
	
	
	
	
	
	

}
