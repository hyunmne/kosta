package com.test06.biz;

import com.test06.entity.Drink;

public class VendingMachineBiz implements IVendingMachineBiz {
	private int balance=1000; // 잔액
	private Drink[] cartList = new Drink[3]; // Drink 타입을 저장할 수 있는 배열 
	private int count = 0; // 배열 갯수


	@Override
	public void cartDrink(Drink drink) {
		if (balance < drink.getPrice()) {
			System.out.println("잔액이 부족하여 구매 불가능합니다.\n");
		} else {
			balance -= drink.getPrice();
			System.out.println(drink.toString()+"를 구입했습니다. 현재 잔액 : " + balance +"\n");
			cartList[count++] = new Drink(drink.getPrice());
		}
		if (cartList.length == count) {
			Drink[] newCartList = new Drink[cartList.length*3];
			for (int i=0; i<cartList.length; i++) {
				newCartList[i] = cartList[i];
			}
			cartList = newCartList;
		}
	}

	@Override
	public void printCart() {
		int coke=0;
		int coffee=0;
		int juice=0;
		int sum=0;

		System.out.println("\n=====움료수 구입 목록=====");
			for (int i=0; i<count; i++) {
				if (cartList[i].getPrice() == 200) {
					juice++;
					sum += 200;
				} else if (cartList[i].getPrice() == 100) {
					coffee++;
					sum += 100;
				} else if (cartList[i].getPrice() == 50) {
					coke++;
					sum+=50;
				}
			}
		System.out.println("주스 : " + juice);
		System.out.println("커피 : " + coffee);
		System.out.println("콜라 : " + coke);
		System.out.println("=====================");
		System.out.println("사용 금액 : " + sum);
		System.out.println("남은 금액 : " + balance + "\n");
	}

	@Override
	public void printDrinkList(Drink[] drinkList) {

		System.out.println("===============");
		System.out.println("   음료수명  가격   ");
		System.out.println("===============");
		
		for (Drink d : drinkList) {
			System.out.println(d+"       "+d.getPrice()+"원");
		}
		System.out.println("===============");
		System.out.println("현재 잔액 : " + balance);
		System.out.println();
	}

}
