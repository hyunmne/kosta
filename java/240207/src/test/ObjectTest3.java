package test;

public class ObjectTest3 {
	
	public static void main(String[] args) {
		Person p1 = new Person("고길동", 20);
		Person p2 = new Person("고길동", 20);
		Person p3 = new Person("고길동", 30);
		Person p4 = new Person("기길동", 20);
		
//		System.out.println(p1.hashCode());
//		System.out.println(p2.hashCode());
//		System.out.println(p3.hashCode());
//		System.out.println(p4.hashCode());
		
		
		Complex c1 = new Complex(3,5);
		Complex c2 = new Complex(3,5);
		Complex c3 = new Complex(5,3);
		
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c3.hashCode());
	}
}
