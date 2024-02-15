package com.test06.entity;

public class Coffee extends Drink {
	public static final int cofPrice = 100;
	public static final String name = "커피";
	
	public Coffee(){
		super(cofPrice);
	}

	@Override
	public String toString() {
		return name+" 	   "+getPrice()+"원";
	}
		
}
