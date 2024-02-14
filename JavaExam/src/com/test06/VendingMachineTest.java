package com.test06;

import java.util.Scanner;

import com.test06.biz.VendingMachineBiz;
import com.test06.entity.Coffee;
import com.test06.entity.Coke;
import com.test06.entity.Drink;
import com.test06.entity.Juice;

public class VendingMachineTest {

	VendingMachineBiz biz = new VendingMachineBiz();
	Scanner sc = new Scanner(System.in);

	public void printMenu() {
		while(true) {
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
			int sel = Integer.parseInt(sc.next());

			Drink[] dl = new Drink[3];
			dl[0] = new Coffee();
			dl[1] = new Coke();
			dl[2] = new Juice();

			if(sel == 9) {
				System.out.println("프로그램 종료");
				break;
			} else if (sel < 0 || sel > 6) {
				System.out.println("메뉴값 확인 후 다시 입력하세요.\n");
			} else {
				switch(sel) {
				case 1: biz.printDrinkList(dl); break;
				case 2: biz.cartDrink(dl[2]); break;
				case 3: biz.cartDrink(dl[0]); break;
				case 4: biz.cartDrink(dl[1]); break;
				case 5: biz.printCart(); break;
				}
			} 
		}
	}

	public static void main(String[] args) {
		VendingMachineTest vend = new VendingMachineTest();
		vend.printMenu();

	}
}
