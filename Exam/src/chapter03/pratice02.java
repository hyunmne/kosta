package chapter03;

public class pratice02 {
	public static void main(String[] args) {
		int numOfApples = 123;
		int sizeOfBucket = 10;
		int numOfBucket 
		= (numOfApples % sizeOfBucket) < sizeOfBucket ? 
				(numOfApples / sizeOfBucket) + 1 : (numOfApples / sizeOfBucket);
		
		System.out.println("필요한 바구니의 수 : " + numOfBucket);
	}
}
