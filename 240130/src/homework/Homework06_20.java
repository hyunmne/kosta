package homework;

// 다음과 같이 정의된 메서드를 작성하고 테스트하시오. 
class Homework06_20 {
	/*
	(1) shuffle메서드를 작성하시오.
	 */
	
	static int[] shuffle(int [] arr) {
		for (int i=0; i<arr.length; i++) {
			arr[i] = (int) (Math.random()*10)+1;
		}
		return arr;
	}
	
	public static void main(String[] args) 
	{
		int[] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(java.util.Arrays.toString(original));
		
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}
}
