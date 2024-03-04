package test;

public class ArrayTest2 {
	public static void main(String[] args) {
		int[][] arr = new int [2][3];
		arr[0][0] = 100;
		arr[0][1] = 24;
		arr[0][2] = 77;
		arr[1][0] = 50;
		arr[1][1] = 67;
		arr[1][2] = 99;
		
		System.out.println(arr.length);
		System.out.println(arr[0].length);
		System.out.println(arr[1].length);
		
		int [][] arr2 = new int[][] {
			{1,2}, {10,20}, {100,200}
		};
		
		int [][] arr3;
		arr3 = new int[][] {{1,2},{10,20},{100,200}};
		
		int sum = 0;
		for (int i=0; i<arr2.length; i++) {
			for (int j=0; j<arr2[i].length; j++) {
				sum += arr2[i][j];
			}
		}
		
		System.out.println(sum);
	}
}
