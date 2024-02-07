package test;

class Person {
	int age;
	String name;
	Person(String name, int age){
		this.name=name;
		this.age=age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Person)) return false;
		Person per = (Person) obj;
		return name.equals(per.name) && age == per.age;
	}
}

public class ObjectTest1 {
	public static void main(String[] args) {
		Person p1 = new Person("홍길동", 20);
		Person p2 = new Person("홍길동", 20);
		Person p3 = new Person("홍길동", 20);
		System.out.println(p1==p2);
		System.out.println(p1.equals(p3));
		System.out.println(p1.equals(p2));
	}
}
