package test;

import java.util.Arrays;
import java.util.Scanner;

//20 이하의 정수 n을 입력 받고 n명의 정수를 입력받아 높은 점수부터 차례로 출력하는 프로그램 작성 

public class ArrayExam10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int[] narr = new int[cnt];  // 입력받은 cnt만큼 배열 확보
		
		for (int i=0; i<narr.length; i++) {
			narr[i] = sc.nextInt();
		}
		
		Arrays.sort(narr);
		for (int i=narr.length-1; i>=0; i--) {
			System.out.print(narr[i]+" ");
		}
		
	}
}
