package test;

class Variables2 {
	int iv; // instance variable
	static int sv; // class variable
	
	void imethod() { //instance method
		System.out.println(iv);
		sv++; // instance method에서는 static variable 사용할 수 있다.
		smethod();
	}
	
	static void smethod() {
		sv++;
//		System.out.println(iv); // static method instance variable 사용할 수 없다.
//		imethod();	// static method에서는 instance method 호출 할 수 없다.
	}
}

public class StaticTest01 {

	public static void main(String[] args) { 
		Variables2.smethod();
		
	}
	
}
