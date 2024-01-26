package test;

import java.util.Scanner;

//5명 학생의 국어 영어 수학 과학 4과목의 점수를 입력 받아서 각 개인별로 평균 80 이상이면 "pass"
//그렇지 않으면 "fail"을 출력하고 합격한 사람의 수롤 출력하는 프로그램을 작성하시오.

public class ArrayExam2_06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] score = new int[5][4];
		
		for (int i=0; i<score.length; i++) {
			String data = sc.nextLine();
			String [] sarr = data.split(" ");
			
			for (int j=0; j<score[i].length; j++) {
				score[i][j] = Integer.parseInt(sarr[j]);
			}
		}
		
		int passCnt = 0;
		for (int i=0; i<score.length; i++) {
			int tot = 0;
			for (int j=0; j<score[i].length; j++) {
				tot += score[i][j];
			}
			if (tot / (double) score[i].length>=80) {
				System.out.println("pass");
				passCnt++;
			} else {
				System.out.println("fail");
			}
		}
		
		System.out.println("Successful : " + passCnt);
		
//		입력한 5명의 학생의 점수 4개를 출력하는 배열 
//		for (int i=0; i<score.length; i++) {
//			for (int j=0; j<score[i].length; j++) {
//				System.out.print(score[i][j]+"\t");
//			}
//			System.out.println();
//		}
	}
}
