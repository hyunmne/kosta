package test;

public class ForTest2 {
	public static void main(String[] args) {
		
//		for (int i=1; i<=9; i++) {
//			System.out.println("2 * " + i +" = "+ (i*2));
//		}
		
//		for (int k=1; k<=9; k++) {
//			for (int i=2; i<=9; i++) {
//				System.out.print(i + " x " + k +" = "+ (i*k) + "\t");
//			}
//			System.out.println();
//		}
		
		
		int j = 1;

		while (j < 10) {
			for (int i=2; i<= 9; i++) {
				System.out.print(i + " x " + j +" = "+ (i*j) + "\t");
			}
			j++;
			System.out.println();
		}
	}
}
