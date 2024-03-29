package test;

class Person implements Cloneable {
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
	
	@Override
	public int hashCode() {
		return name.hashCode()+age;
	}
	
	@Override
	public String toString() {
		return String.format("이름:%s, 나이:%s", name, age);
	}
	
	@Override
	protected Object clone() {
		Object obj=null; 
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
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
