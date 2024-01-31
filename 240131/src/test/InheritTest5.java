package test;

class Parent1{
	int x=10;
	void method2() {
		System.out.println("Parent1 method2");
	}
	
	void method3() {
		System.out.println("Parent1 method3");
	}
}

class Child1 extends Parent1 {
	int x=20;
	void method() {
		System.out.println(x);
		System.out.println(this.x);
		System.out.println(super.x);
	}
	
	void method1() {
		method2();
		this.method2();
	}
	
	void method2() {
		System.out.println("Child1 method2");
	}
	
	void method3() {
		method3();
		System.out.println("Child1 method3");
	}
}

public class InheritTest5 {
	public static void main(String[] args) {
		Child1 c1 = new Child1();
		c1.method3();
	}
}
