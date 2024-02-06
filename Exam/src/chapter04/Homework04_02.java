package chapter04;

public class Homework04_02 {
	public static void main(String[] args) {
//		1부터 20까지의 정수 중에서 2 또는 3의 배수가 아닌 수의 총합을 구하시오.
		
//		int num = 0, cnt=0;
//		
//		do {
//			if (num%2 != 0 && num%3 != 0) cnt++;  
//		} while (num!=20);
		
		int sum = 0;
		
		for (int i=0; i<=20; i++) {
			if (i%2 != 0 && i%3 != 0) sum+= i;
		}
		
		System.out.println(sum);
		
		
	}
}
