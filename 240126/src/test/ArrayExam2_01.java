package test;

import java.util.Scanner;

// 1부터 10까지의 정수를 입력 받다가 입력된 정수가 범위를 벗어나면 그때까지 1번 이상 입력된
// 각 숫자의 개수를 작은 수부터 출력하는 프로그램을 작성하시오.

public class ArrayExam2_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];

		int num = 0;
		int i = 0;

		for (; i<arr.length-1; i++) {
			num = sc.nextInt();
			if (num<1 || num>10) { // num의 범위를 벗어났을 경우
				break ;
			}
			else {
				arr[num-1]++;
			}
		}

		for (int j=0; j<arr.length; j++) {
			if(arr[j] != 0) {
				System.out.println(j+1+" : "+arr[j]+"개");
			}
		}
	}
}
