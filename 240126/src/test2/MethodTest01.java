package test2;

public class MethodTest01 {
	
	// 함수의 정의 
	public static int sum(int[] arr) {
		int tot = 0;
		for(int i=0; i<arr.length; i++) {
			tot += arr[i];
		}
		return tot;
	}
	
	public static void main(String[] args) {
		int[] arr1 = {10,20,30,40,50};
		int[] arr2 = {100,200,300,400,500,600};
		
		System.out.println(sum(arr1));
		System.out.println(sum(arr2));
	}
}
