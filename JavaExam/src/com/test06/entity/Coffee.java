package com.test06.entity;

public class Coffee extends Drink {
	public int cofPrice = 100;
	static final String name = "커피";
	
	public Coffee(){
		super.setPrice(cofPrice);
	}

	@Override
	public String toString() {
		return name;
	}
		
}
