package test;

// 메소드 안에서 선언된 변수는 지역변수라고 부른다.
class Variables {
	int iv;
	static int sv; // static : 클래스 당 하나만 생성
	
	void method() {
		System.out.println(iv);
		int lv = 20;
		System.out.println(lv);
	}
	
	void method2() {
		int lv = 30;
		System.out.println(lv);
	}
	
}

public class ClassTest03 {
	public static void main(String[] args) {
		Variables v = new Variables();
		v.iv = 10;
		Variables.sv = 1000;
		v.method();
		v.method2();
		
		Variables v2 = new Variables();
		v2.iv = 100;
		System.out.println(Variables.sv);
	}
}
