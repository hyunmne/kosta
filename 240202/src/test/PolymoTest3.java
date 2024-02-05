package test;

class Parent1 {
	int pn;

	void method1() {
		System.out.println("Parent method1");
	}
}

class Child1 extends Parent1 {
	int cn;

	@Override
	void method1() {
		System.out.println("Child method1");
	}
	
	void method2() {
		System.out.println("method2");
	}
}

public class PolymoTest3 {
	public static void main(String[] args) {
		
		Parent1 p = new Parent1();
		p.method1();  //Parent method1
		Parent1 c = new Child1();
		c.method1();  //Child method1
		c.pn = 10;
//		c.cn = 20;  //★★★타입을 우선적으로 생각! parent1에는 cn이 없으니 오류 (예외: 오버라이딩 할 때는 new 한 게 우선)
//		c.method2();  //parent1타입이기 때문에 child1클래스에 있는 메서드 호출 불가
		
		//다운캐스팅
		Child1 t = (Child1)c;
		t.method2();
		//위 코드를 한 번에 작성
		((Child1)c).method2();  //다운캐스팅 후 메서드 호출 가능(괄호 필수)
	}
}
