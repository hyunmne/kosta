package test;

// 피보나치 수열

public class ArrayExam2_04 {
	public static void main(String[] args) {
		int[] fibo = new int[40];
		fibo[0] = fibo[1] = 1;
		
		for(int i=2; i<fibo.length; i++) {
			fibo[i] = fibo[i-2] + fibo[i-1];
		}
		
		System.out.println(String.format("피보나치 수열 %d항 : %d", 10, fibo[9]));
		System.out.println(String.format("피보나치 수열 %d항 : %d", 20, fibo[19]));
		System.out.println(String.format("피보나치 수열 %d항 : %d", 30, fibo[29]));
		System.out.println(String.format("피보나치 수열 %d항 : %d", 40, fibo[39]));
	}
}
