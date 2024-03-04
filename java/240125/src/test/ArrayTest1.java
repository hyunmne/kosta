package test;

public class ArrayTest1 {
	public static void main(String[] args) {
		
		int[] score = {10,20,30,40,50}; // 배열 생성 (0 ~ 4)
		int sum = 0;
		
		for (int i=0; i<score.length; i++) {
//			System.out.println(score[i]);
			sum += score[i];
		}
		System.out.println(sum);
		System.out.println((double)sum/score.length);
	}
}
