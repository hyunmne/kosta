package test;

import java.util.Scanner;

//6명의 몸무게를 입력 받아 몸무게의 평균을 프로그램을 작성하시오.
//출력은 반올림하여 소수 첫째짜리로 한다.

public class ArrayExam05 { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double sum = 0;
		double avg = 0;
		// 6개의 배열 생성
		double [] weight = new double [6];
		
		for (int i=0; i<weight.length; i++) {
			System.out.println(i+1 + "번째 사람의 몸무게를 입력하세요.");
			// 입력받아 배열에 할당
			weight[i] += sc.nextDouble();
			// 총합 구하기
			sum += weight[i];
		}
		
		// 몸무게의 평균을 구하고 소숫점 첫째자리에서 반올림
		avg = Math.round(sum / weight.length * 10)/10;
		System.out.println("몸무게의 평균은 "+avg+"kg 입니다.");
		
	}
}
