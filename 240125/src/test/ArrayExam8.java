package test;

import java.util.Scanner;

//100개 이하의 정수를 입력 받다가 0이 입력되면 그때까지 입력된 정수 중 5의 배수의 개수와
//합계 평균을 출력하는 프로그램을 작성하시오. 평균은 소수점 이하 1자리까지 출력한다.

public class ArrayExam8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int [100];
		int val = 0, i = 0;
		int cnt = 0, sum = 0;
		double avg = 0;

		for (; i<arr.length; i++) {
			val = sc.nextInt();
			if (val == 0) break;
//			val = arr[i];
			arr[i] = val;
		}

		for (int j=0; j<i; j++) {
			if (arr[j] % 5 == 0) {
				cnt++;
				sum += arr[j];
			}
		}

		avg = sum / (double)cnt;

		System.out.println("Multiples of 5 : " + cnt);
		System.out.println("sum : " + sum);
		System.out.println("avg : " + avg);

	}
}
