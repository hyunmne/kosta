package test;

import java.util.Scanner;

public class ArrayExam2_06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String data = sc.nextLine();
		
		// 한 문장으로 입력받은 데이터를 숫자 단위로 끊어서 배열에 저장
		int[] arr = new int[5];
		String[] sarr = data.split(",");
		for (int i=0; i<sarr.length; i++) {
			arr[i] = Integer.parseInt(sarr[i]);
		}
		
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
