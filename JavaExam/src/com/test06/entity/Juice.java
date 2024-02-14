package com.test06.entity;

public class Juice extends Drink {
	public int juPrice = 200;
	
	public Juice(){
		super.setPrice(juPrice);
	}
	
	@Override
	public String toString() {
		return "주스 구입하기 ( "+juPrice+"원 )";
	}
}
