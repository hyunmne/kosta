package test;

import java.util.Scanner;

public class WhileTest2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		2부터 9까지의 수 중 2개를 입력 받아 입력 받은 수 사이의 구구단을 출력하는 프로그램을 작성하시오.
//		단 반드시 먼저 입력된 수의 구구단부터 아래의 형식에 맞게 출력해야 한다,
//		구구단 사이의 공백은 3칸이다.
		
		int dan1 = sc.nextInt();
		int dan2 = sc.nextInt();
		
		for (int i=1; i<=9; i++) {
			if (dan1 > dan2) {
				for (int j = dan1; j>=dan2; j--) {
//					System.out.print(j+"x"+i+"="+j*i+"\t");
					System.out.print(String.format("%d * %d = %2d   ", j, i, j*i));
				}
			} else {
				for (int j = dan1; j<=dan2; j++) {
					System.out.print(String.format("%d * %d = %2d   ", j, i, j*i));
				}
			}
			System.out.println();
		}
	}
}
