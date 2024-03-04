package test;

class MyException1 extends Exception{}
class MyException2 extends Exception{}

public class ExceptionTest6 {
	static void func() throws MyException1, MyException2 {
		func2();
		throw new MyException2();
	}
	
	static void func2() throws MyException1 {
		throw new MyException1();
	}
	
	public static void main(String[] args) {
		try {
			func();
		} catch (MyException1 e) {
		} catch (MyException2 e) {
		}
	}
}
