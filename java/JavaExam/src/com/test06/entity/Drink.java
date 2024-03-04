package com.test06.entity;

public class Drink {
	private int price;
	private String name;
	
	public Drink(){}
	
	public Drink(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

}
