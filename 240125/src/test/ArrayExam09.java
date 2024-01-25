package test;

import java.util.Scanner;

//정수를 입력받다가 0이 입력되면 0을 제외하고 그 때까지 입력 받은 개수를 출력한 후
//입력받은 정수를 차례로 출력하되 그 수가 홀수이면 2배한 값을,
//짝수인 경우에는 2로 나눈 몫을 출력하는 프로그램을 작성
//입력되는 정수의 개수는 100개 이하이다.

public class ArrayExam09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] arr = new int [100];
		
		int i = 0;
		int val = 0, cnt = 0;
		
		for (; i<arr.length; i++) {
			val = sc.nextInt();
			if (val == 0) break;
			arr[i] = val;
			cnt++;
		}
		
		System.out.println(cnt);
		
		for (int j=0; j<i; j++) {
			if (arr[j] % 2 != 0) {
				arr[j] = arr[j]*2; 
			} else {
				arr[j] = arr[j] / 2;
			}
			System.out.print(arr[j] + " ");
		}
	}
}
