package com.test03;

public class TestMain03 {
	public static void main(String[] args) {
		String str = "1.22,4.12,5.93,8.71,9.34"; 
		//StringTokenizer 이용하여 List에 저장한다.
		//List에 저장된 데이터의 합과 평균을 구한다.
		double sum=0, avg=0;
		int cnt=0;
		
		String[] strr = str.split(",");
		
		for (int i=0; i<strr.length; i++) {
			sum += Double.parseDouble(strr[i]);
			cnt++;
		}
		avg = sum / cnt;
		
		System.out.printf("합 계 : %.3f", sum);
		System.out.println();
		System.out.printf("평 균 : %.3f", avg);
	}
}
