package test;

import java.util.Scanner;

//세 자리 이하의 정수를 차례로 입력 받다가 999가 되면 프로그램을 종료하고
//그 때가지 입력된 최대값과 최소값을 출력하는 프로그램을 작성하시오.
//입력 받는 정수는 100개 이하이다.

public class ArrayExam07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] narr = new int[100];
		int val = 0, i=0;
		
		int max = narr[0];
		int min = narr[0];
		
		// 배열에 값 할당 
		for (; i<narr.length; i++) {
			val = sc.nextInt();
			if (val == 999) break;
			narr[i] = val;
		}

		// 배열의 최솟값 최댓값 구하기 
		// i번 (배열의 길이만큼 반복)
		for (int j=0; j<i; j++) {
			if (narr[j]>max) max=narr[j];
			if (narr[j]<min) min=narr[j];
		}
		
		System.out.println("max : " + max);
		System.out.println("min : " + min);
	}
}
