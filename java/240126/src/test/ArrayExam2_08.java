package test;

// 배열을 만들어서 아래와 같이 저장한 후 출력하는 프로그램을 작성하시오.
// 규칙은 첫 번째 행은 모두 1로 초기화 하고 다음 행부터는 바로 위의 값과 바로 왼쪽 값을 더한 것이다.
// 1 1 1 1 1
// 1 2 3 4 5
// 1 3 6 10 15
// 1 4 10 20 35
// 1 5 15 35 70

public class ArrayExam2_08 {
	public static void main(String[] args) {
		int[][] arr = new int[5][6];
		for (int i=1; i<arr[0].length; i++) {
			arr[0][i] = 1; // 0번째 행을 전부 1로 채운다.
		}

		for(int i=1; i<arr.length; i++) {
			for (int j=1; j<arr[i].length; j++) {
				arr[i][j] = arr[i][j-1] + arr[i-1][j];
			}
		}

		for (int i=0; i<arr.length; i++) {
			for(int j=1; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
		System.out.println();
		}
	}
}
