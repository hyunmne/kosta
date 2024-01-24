package homework;

//구구단의 일부분을 다음과 같이 출력하시오.

public class Homework04_12 {
	public static void main(String[] args) {
		
		int j = 1;

		while (j < 4) {
			for (int i=2; i<= 9; i++) {
				System.out.print(i + " x " + j +" = "+ (i*j) + "\t");
			}
			j++;
			System.out.println();
		}
	}
}
