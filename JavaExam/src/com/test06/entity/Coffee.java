package com.test06.entity;

public class Coffee extends Drink {
	public int cofPrice = 100;
	
	public Coffee(){
		super.setPrice(cofPrice);
	}

	@Override
	public String toString() {
		return "커피 구입하기 ("+cofPrice+"원 )";
	}
		
}
