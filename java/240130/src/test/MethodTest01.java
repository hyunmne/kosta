package test;

public class MethodTest01 {
	
	void method1(int val) {
		System.out.println("method1 시작");
		int val2 = val;
		method2(val2);
		System.out.println("method1 종료");
	}
	
	void method2(int val) {
		System.out.println("method2 시작");
		val += 10;
		method3(val);
		System.out.println("method2 종료");
	}
	
	void method3(int arg) {
		System.out.println("method3 시작");
		arg += 100;
		System.out.println(arg);
		System.out.println("method3 종료");
	}
	
	public static void main(String[] args) {
		System.out.println("main 시작");
		MethodTest01 mt = new MethodTest01();
		mt.method1(5);
		System.out.println("main 종료");
	}
}
