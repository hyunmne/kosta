package com.test06.entity;

public class Juice extends Drink {
	public int juPrice = 200;
	static final String name = "주스";
	
	public Juice(){
		super.setPrice(juPrice);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
