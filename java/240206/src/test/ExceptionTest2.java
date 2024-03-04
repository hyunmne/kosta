package test;

public class ExceptionTest2 {
	public static void main(String[] args) {
		int[] arr1 = {10,20,30,40, 50};
		int[] arr2 = {2,0,6,8};
		
		for (int i=0; i<arr1.length; i++) {
			try {
				System.out.println(arr1[i] / arr2[i]);
			} catch(ArithmeticException e) {
				System.out.println(e.getMessage());
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println(0);
			}
		}

	}
}


// 5
// /by zero
// 5
// 5