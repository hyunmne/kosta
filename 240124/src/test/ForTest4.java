package test;

public class ForTest4 {
	public static void main(String[] args) {
		
//		a 1 2 3 4
//		b c 5 6 7
//		d e f 8 9
//		g h i j 10
		
		char ch1 = 'a';
		int num = 1;
		
		for (int i=0; i<4; i++) {
			
			for (int j=0; j< i+1; j++) {
				System.out.print((ch1++)+" ");
			}
			for (int k=4; k>i; k--) {
				System.out.print((num++)+" ");
			}
			System.out.println();
		}
		
		System.out.println();
//		1 2 3 A
//		4 5 B C
//		6 D E F
		
		char ch2 = 'A';
		int num2 = 1;
		
		for (int i=0; i<3; i++) {
			for (int j=3; j>i; j--) {
				System.out.print(num2++ + " ");
			}
			
			for (int k=0; k<i+1; k++) {
				System.out.print(ch2++ + " ");
			}
			System.out.println();
		}
		
		
	}
}
