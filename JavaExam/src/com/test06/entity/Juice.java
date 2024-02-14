package com.test06.entity;

public class Juice extends Drink {
	public int juPrice = 200;
	static final String name = "주스";
	
	public Juice(){
		super.setPrice(juPrice);
		super.setName(name);
	}
	
	@Override
	public String toString() {
		return "주스 	   "+getPrice()+"원";
	}
}
