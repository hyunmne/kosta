package test;

public class ForTest {
	public static void main(String[] args) {
		int sum = 0;
		
//		for (int i=1; i<=100; i++) {
//			sum += i;
//		}
		
//		for (int i=1; i<=100; i++) {
//			if (i%2==1) { // i가 만약에 홀수면
//				sum += i;
//			}
//		}
		
//		for (int i=1; i<=100; i++) {
//			if (i%2!=1) { // i가 만약에 짝수면 
//				sum += i;
//			}
//		}
		
//		for (int i=1; i<=100; i++) {
//			if (i%3!=1) { // i가 만약에 3의 배수가 아니라면 
//				sum += i;
//			}
//		}
		
//		for (int i=1; i<=100; i++) {
//			if (i%3==1) { // i가 만약에 3의 배수라면  
//				sum += i;
//			}
//		}
		
		for (int i=1; i<=100; i++) {
			sum += i;
			
			if (sum >= 100) {
				System.out.println(i);
				break;
			}
		}
		
		System.out.println(sum);
		
	}
}
