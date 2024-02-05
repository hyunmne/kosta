package test;

abstract class Unit {
	abstract void move();
	void method1() {}
}

interface Attackable{
	void attack();
}

class Fighter extends Unit implements Attackable{

	@Override
	public void attack() {}

	@Override
	void move() {}
	
	void method2() {}
	
}

public class InterfaceTest01 {
	public static void main(String[] args) {
		Fighter f1 = new Fighter();
		f1.move();
		f1.attack();
		f1.method1();
		f1.method2();
		
		Unit f2 = new Fighter();
		f2.move(); // fighter 다형성
//		f2.attack();  // error
		f2.method1();
//		f2.method2(); // error
		
		Attackable f3 = new Fighter();
		f3.attack(); // fighter 다형성
//		f3.move();		// error
//		f3.method1();	// error
//		f3.method2();	// error
		
		Object f4 = new Fighter();
//		f4.move();		// error
//		f4.attack(); 	// error
//		f4.method1();	// error
//		f4.method2();	// error
	}
}
