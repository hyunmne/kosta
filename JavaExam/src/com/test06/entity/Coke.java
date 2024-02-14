package com.test06.entity;

public class Coke extends Drink {
	public int cokPrice = 50;
	
	public Coke(){
		super.setPrice(cokPrice);
	}
	
	@Override
	public String toString() {
		return "코크 구입하기 ("+cokPrice+"원 )";
	}
}
