package test;

public class ObjectTest4 {
	
	public static void main(String[] args) {
		Person p1 = new Person("고길동", 20);
		Person p2 = new Person("고길동", 20);
		Person p3 = new Person("고길동", 30);
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
		
		Complex c1 = new Complex(3,5);
		Complex c2 = new Complex(3,5);
		Complex c3 = new Complex(5,3);
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());
	}
}
