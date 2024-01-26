package test;

import java.util.Scanner;

//int[행][열] arrForm = new int[행][열];
// 아래와 같은 파스칼 삼각형을 출력하는 프로그램을 작성하시오.
// 파스칼 삼각형은 첫 번째 줄 첫 번째 행을 1로 초기화 한 후 
// 다음 줄부터는 바로 위의 값과 바로 위 왼쪽의 값을 더한 값이 된다.

// 1 0 0 0 0 
// 1 1 0 0 0 
// 1 2 1 0 0 
// 1 3 3 1 0 
// 1 4 6 4 1 

public class ArrayExam2_07 {
	public static void main(String[] args) {
		int[][] tri = new int[5][6];
		tri[0][1] = 1;
		
		for (int i=1; i<tri.length; i++) {
			for (int j=1; j<tri[i].length; j++) {
				tri[i][j] = tri[i-1][j] + tri[i-1][j-1];
			}
		}
		
		for (int i=0; i<tri.length; i++) {
			for (int j=1; j<tri[i].length; j++) {
				if (tri[i][j]!=0) {
					System.out.print(tri[i][j]+" ");
				}
			}
			System.out.println();
		}
	}	
}
