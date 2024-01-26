package test;

import java.util.Scanner;

// 6학년이 4반이 있는데 각 반의 대표를 세 명씩 선발하여 제기차기 시합을 한다.
// 반별로 세 명이 제기를 찬 개수를 입력 받아 각 반 별로 제기를 찬 개수의 합계를 출력하는 프로그램 작성

// 입력					출력
// 1class? 15 2 35 		1class : 52	
// 2class? 33 1 6 		2class : 40
// 3class? 5 10 19 		3class : 34	
// 4class? 1 8 55 		4class : 64	

public class ArrayExam2_11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[4][3];
		String data;

		for (int i=0; i<arr.length; i++) {
			System.out.print(i+1+"class? ");
			data = sc.nextLine();
			String[] cnts = data.split(" ");
			
			// 공백 단위로 끊은 값을 반복해서 넣어준다
			for (int j=0; j<arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(cnts[j]);
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			int cnt = 0;
			for (int j=0; j<arr[i].length; j++) {
//				합계를 구한다
				cnt += arr[i][j];
			}
			System.out.println(i+1+"class : " + cnt);
		}


	}
}
