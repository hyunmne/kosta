package test;

public class LottoExam {
	public static void main(String[] args) {

		int[] lotto = new int[45]; // 배열 생성

		for (int i=0; i<lotto.length; i++) {
			lotto[i] = i+1; // 1부터 45까지 배열 초기화
		}

		// 1 - 45 사이의 숫자를 랜덤으로 뽑아서 스와핑 하기
		for (int i=0; i<1000; i++) {
			int rand1 = (int) (Math.random()*45);
			int rand2 = (int) (Math.random()*45);

			int num = lotto[rand1];
			lotto[rand1] = lotto[rand2];
			lotto[rand2] = num;
		}
		
		// for문으로 배열 맨 앞 6자리 숫자 뽑기 
		for (int i=0; i<6; i++) {
			System.out.print(lotto[i]+1+" ");
		}
	}
}
