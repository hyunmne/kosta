package com.test06.entity;

public class Coke extends Drink {
	public int cokPrice = 50;
	static final String name = "코크";
	
	public Coke(){
		super.setPrice(cokPrice);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
