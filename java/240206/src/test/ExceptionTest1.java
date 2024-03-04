package test;

public class ExceptionTest1 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		
		try {
			System.out.println(3);
			int a = 10/0;
			System.out.println(4);
		} catch (NumberFormatException e) {
			System.out.println("예외처리2");
		} catch (ArithmeticException e) {
			System.out.println("예외처리2");
		}
		System.out.println("종료");
	}
}
