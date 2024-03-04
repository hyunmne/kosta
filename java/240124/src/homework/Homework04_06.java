package homework;

//두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프
//로그램을 작성하시오.

public class Homework04_06 {
	public static void main(String[] args) {
		
		int num1 = 0;
		int num2 = 0;
		int cnt = 0;
		
		for (num1=1; num1 <=6; num1++) {
			for (num2 = 1; num2 <= 6; num2++) {
				if ((num1+num2) == 6) {
					cnt++;
				}
			}
		}
		System.out.println("모든 경우의 수는 " + cnt);
	}
}
