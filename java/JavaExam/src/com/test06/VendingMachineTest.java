package com.test06;

import java.util.Scanner;

import com.test06.biz.VendingMachineBiz;
import com.test06.entity.Coffee;
import com.test06.entity.Coke;
import com.test06.entity.Drink;
import com.test06.entity.Juice;

public class VendingMachineTest {

	private static void printMenu() {
		System.out.println("============================");
		System.out.println("     [음료수 자판기 관리 시스템]	");
		System.out.println("============================");

		System.out.println("1. 전체 음료수 및 잔액 보기");
		System.out.println("2. 쥬스 구입하기 ( 200원 )");
		System.out.println("3. 커피 구입하기 ( 100원 )");
		System.out.println("4. 코크 구입하기 (  50원 )");
		System.out.println("5. 구입한 음료수 목록 보기");
		System.out.println("9. 종료\n");
		System.out.println("============================");
		System.out.print("메뉴 입력 => ");

	}

	public static void main(String[] args) {
		VendingMachineBiz biz = new VendingMachineBiz();
		Scanner sc = new Scanner(System.in);
		Drink[] drinkList = {new Coffee(), new Juice(), new Coke()};

		while (true) {
			printMenu();
			String sel = sc.nextLine();
			switch(sel) {
			case "1": biz.printDrinkList(drinkList); break;
			case "2": biz.cartDrink(new Juice()); break;
			case "3": biz.cartDrink(new Coffee()); break;
			case "4": biz.cartDrink(new Coke()); break;
			case "5": biz.printCart(); break;
			case "9": break;
			default: System.out.println("메뉴값을 확인 후 다시 입력해주세요.");
			}
		}
	}
}
