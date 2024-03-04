package test;

public class ExceptionTest4 {

	public static void func() {
		String str = null;
		try {
			System.out.println(str.toString());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		
		func();
	}
}
