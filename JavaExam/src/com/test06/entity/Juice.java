package com.test06.entity;

public class Juice extends Drink {
	public static final int juPrice = 200;
	public static final String name = "주스";
	
	public Juice(){
		super(juPrice);
	}
	
	@Override
	public String toString() {
		return name+" 	   "+getPrice()+"원";
	}
}
