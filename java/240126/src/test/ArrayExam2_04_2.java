package test;

public class ArrayExam2_04_2 {
	public static void main(String[] args) {
		int ppre = 1;
		int pre = 1;
		int curr;
		
		for (int i=3; i<=40; i++) {
			curr = ppre + pre;
			ppre = pre;
			pre = curr;
			
			switch(i) {
				case 10:
					System.out.println("피보나치 수열 10항 : "+curr);
					break;
				case 20:
					System.out.println("피보나치 수열 20항 : "+curr);
					break;
				case 30:
					System.out.println("피보나치 수열 30항 : "+curr);
					break;
				case 40:
					System.out.println("피보나치 수열 40항 : "+curr);
					break;
			}
			
//			if (i%10==0) {
//				System.out.println("피보나치 수열 "+i+"항 : "+curr);
//			}
		}
		
		
	}
}
