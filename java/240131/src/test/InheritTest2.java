package test;

// 부모
class Base {
	int n;
	void method1() {
		System.out.println("Base method1");
	}
}

// 자식
class Derived extends Base {
	int m;
	
	@Override
	void method1() {
		System.out.println("Derived method1");
	}
	
	void method2() {
		System.out.println("Derived method2");
	}
}

public class InheritTest2 {
	public static void main(String[] args) {
		Base b = new Base();
		b.n = 10;
		b.method1();
		
		// 자식은 부모 클래스의 변수 메소드를 다 가져올 수 있음
		Derived d = new Derived();
		d.n = 100;
		d.m = 200;
		d.method1(); // Derived method1
		d.method2();
	}
}
