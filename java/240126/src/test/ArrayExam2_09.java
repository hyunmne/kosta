package test;

import java.util.Scanner;

// 학생들의 점수를 입력 받다가 0이 입력되면 그 때가지 입력받은 점수를 10점 단위로 구분하여
// 점수대별 학생 수를 출력하는 프로그램을 작성
// 학생은 최대 100명, 1명도 없는 점수는 출력 ㄴ

// 입력 	         						// 출력
// 63 80 95 100 46 64 88 0              // 100 : 1 person
										// 90 : 1 person 
                                        // 80 : 2 person 
                                        // 60 : 2 person 
                                        // 40 : 1 person 

public class ArrayExam2_09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] score = new int[11]; // 0점대 ~ 100점대
		int val; 
		
		while(true) {
			val = sc.nextInt();
			if (val==0) break;
			
			score[val/10]++;
		}
		
		for(int i=score.length-1; i>=0; i--) {
			if (score[i]!=0) {
				System.out.println(String.format("%d : %d person", i*10, score[i]));
			}
		}
	}
}
