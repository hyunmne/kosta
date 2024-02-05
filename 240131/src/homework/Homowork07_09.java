package homework;

class MyClass {
	final static int fsn = 10;
	final int fin;
	
	MyClass(){
		fin = 0;
	}
	
	MyClass(int i) {
		this.fin = i;
	}
	final void method() {
		
	}

}


class ChildMyClass extends MyClass {
	
}

public class Homowork07_09 {
	public static void main(String[] args) {
		MyClass mc1 = new MyClass(5);
		MyClass mc2 = new MyClass(3);
		System.out.println(MyClass.fsn); //10
		System.out.println(mc1.fsn); //10
		System.out.println(mc2.fsn); // 10
//		MyClass.fsn = 20; //error 변경 불가
		
		System.out.println(mc1.fin); // 5
		System.out.println(mc2.fin); // 3
//		mc1.fin = 100; // error 변경 불가
//		mc2.fin = 200; // error 변경 불가
	}
}
