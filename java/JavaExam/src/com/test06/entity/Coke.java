package com.test06.entity;

public class Coke extends Drink {
	public static final int cokPrice = 50;
	public static final String name = "코크";
	
	public Coke(){
		super(cokPrice);
	}
	
	@Override
	public String toString() {
		return name+" 	   "+getPrice()+"원";
	}
}
