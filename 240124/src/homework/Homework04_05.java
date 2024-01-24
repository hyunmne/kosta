package homework;
// for문 > while문 변경

public class Homework04_05 {
	public static void main(String[] args) {
		
//		for(int i=0; i<=10; i++) { 
//			for(int j=0; j<=i; j++)
//				System.out.print("*");
//			System.out.println();
//		}
		
		int i = 0;

        while (i <= 10) { // i가 10 이하일 동안 돌아감 
            int j = 0;

            while (j <= i) { // j가 i 이하일 동안 돌아감
                System.out.print("*");
                j++;
            }

            System.out.println();
            i++; // i 횟수 올려주기 
		}
		
	}
}
