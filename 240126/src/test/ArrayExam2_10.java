package test;

import java.util.Scanner;

// 10 미만의 자연수 두 개를 입력 받아서 첫 번째 항과 두 번째 항을 입력 받은 수로 초기화 시킨 후
// 세 번재 항부터는 전전항과 전항의 합을 구하여 그 합의 1의 자리로 채워서 차례로 10개를 출력하는 프로그램

// 입력			출력
// 3 5			3 5 8 3 1 4 5 9 4 3 	

public class ArrayExam2_10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		
		for(int i=2; i<arr.length; i++) {
			arr[i] = (arr[i-1]+arr[i-2])%10;
		}
		
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
