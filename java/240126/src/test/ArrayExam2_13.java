package test;

import java.util.Scanner;

// 4행 2열의 배열을 입력 받아 가로 평균과 세로 평균 그리고 전체 평균을 출력하는 프로그램 작성
// 소수점 이하는 버린다.

// 입력				출력
// 16 27			21 69 53 40  	
// 39 100           33 58 
// 19 88            46
// 61 20

public class ArrayExam2_13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[4][2];
		
		// 데이터 입력 받고 공백 단위로 끊어서 배열에 저장하기
		for (int i=0; i<arr.length; i++) {
			String data = sc.nextLine();
			String[] sarr = data.split(" ");
			
			for (int j=0; j<arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(sarr[j]);
			}
		}
		
		int total = 0;
		
		// 가로 평균 구하기
		for (int i=0; i<arr.length; i++) {
			int sum = 0;
			for (int j=0; j<arr[i].length; j++) {
				sum += arr[i][j];
				total += arr[i][j];
			}
			System.out.print(sum / arr[i].length+ " ");
		}
		
		System.out.println();
		
		// 세로 평균 구하기
		for (int i=0; i<arr[0].length; i++) {
			int sum = 0;
			for (int j=0; j<arr.length; j++) {
				sum += arr[j][i];
			}
			System.out.print(sum / arr.length+ " ");
		}
		
		System.out.println();
		// 전체 평균 구하기
		System.out.println(total/(arr.length*arr[0].length));
	}
}
