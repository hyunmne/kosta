package homework;

// 다음은 배열 answer에 담긴 데이터를 읽고 각 숫자의 개수를 세어서 개수만큼 '*'을 찍어서 그래프를 그리는 프로그램이다.

public class Homework08 {
	public static void main(String[] args) {
		int[] answer = { 1,4,4,3,1,4,4,2,1,3,2 };
		int[] counter = new int[4];
		
		// 숫자 갯수 세기
		for(int i=0; i < answer.length;i++) { // 20번 반복
			counter[answer[i]-1]++;
		}
		
		// 숫자 개수만큼 별 찍기 
		for(int i=0; i < counter.length;i++) {
			System.out.println(i+1 + "의 개수 : " + counter[i]);
			for (int j=0; j<counter[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
