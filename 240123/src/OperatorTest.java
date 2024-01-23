public class OperatorTest {
	public static void main(String[] args) {
		int n1 = 10, n2 = 10;
		int r1, r2;
		
		r1 = ++n1; // 11
		r2 = n2++; // 11
		
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(n1);
		System.out.println(n2);
		
		int t = n1+n2;
		
//		별찍기
//		for (int i=0; i<6; i++) {
//			for (int k=0; k<i; k++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		int x = 20, y=30;
		int max = x>y? x:y;
		System.out.println(max);
		
		int i = 10;
		i += 3+5; // i=i*(3+5)
		
		
	}
}
