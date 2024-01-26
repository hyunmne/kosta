package test;

import java.util.Scanner;

// 정수를 입력 받다가 0이 입력되면 마지막에 입력된 0을 제외하고 그때까지 입력된 정수의
// 일의 자리 숫자가 각각 몇 개인지 작은 수부터 출력하는 프로그램
// 0개의 숫자는 출력 ㄴ

// 입력 				 				// 출력    
// 10 55 123 63 85 61 125 0         // 0 : 1개
                                    // 1 : 1개
                                    // 3 : 2개
                                    // 5 : 3개

public class ArrayExam2_03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] count = new int[10];
		int val;
		
		while(true) {
			val = sc.nextInt();
			if(val==0) break;
			count[val%10]++; // 일의 자리의 수를 배열에 넣는다.
		}
		for (int i=0; i<count.length; i++) {
			if(count[i]!=0) {
				System.out.println(String.format("%d : %d개", i, count[i]));
			}
		}
	}
}
