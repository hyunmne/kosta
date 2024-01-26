package test;

import java.util.Scanner;

// 100 이하의 자연수를 입력 받아 첫 번째 항은 100으로 두 번째 항은 입력 받은 수로 초기화하고
// 다음 항부터는 전전항에서 전항을 뺀 수로 채워나가는 수열을 작성하여 그 수가 음수가 나올 때까지
// 출력하는 프로그램을 작성하시오.

// 입력 					출력
// 62 					100 62 38 24 14 10 4 6 -2

public class ArrayExam2_05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int first = 100;
		int second = sc.nextInt();
		int next = 0;

		System.out.print(first+" "+second+" ");

		while (!(next < 0)) {
			next = first - second;
			first = second;
			second = next;
			System.out.print(next+" ");
			if (next<0) break;
			
		} 
	}
}
