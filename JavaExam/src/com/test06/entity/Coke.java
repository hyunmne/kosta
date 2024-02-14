package com.test06.entity;

public class Coke extends Drink {
	public int cokPrice = 50;
	static final String name = "코크";
	
	public Coke(){
		super.setPrice(cokPrice);
		super.setName(name);
	}
	
	@Override
	public String toString() {
		return "코크 	   "+getPrice()+"원";
	}
}
