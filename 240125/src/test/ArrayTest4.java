package test;

public class ArrayTest4 {
	
	// 출력 메소드
	static void print(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {10, 20, 30, 40, 50};
		int[] arr2 = new int[arr.length];

		// 배열의 복사
		// arr의 0번째부터 arr2의 0번째
		System.arraycopy(arr, 0, arr2, 0, arr.length);
		
		int[] arr3 = arr.clone(); // 배열의 복제 (2)
		
		print(arr);
		System.out.println();
		print(arr2);
		System.out.println();
		print(arr3);
 	}
}
