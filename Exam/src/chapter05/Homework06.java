package chapter05;

// 거스름돈 문제
// 변수 money의 금액을 동전으로 바꿨을 때 각각 몇 개의 동전이 필요한지 계산해서 출력하라
// 가능한 적은 수의 동전으로 거슬러 주어야 한다.

public class Homework06 {
	public static void main(String[] args) {
		int[] coinUnit = {500, 100, 50, 10};

		int money = 2680;
		System.out.println("money="+money);

		for (int i=0; i<coinUnit.length; i++) {
			System.out.println(coinUnit[i]+"원 : " + money/coinUnit[i] );
			money %= coinUnit[i];
		}
	}
}
