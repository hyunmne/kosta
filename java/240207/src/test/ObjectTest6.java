package test;

public class ObjectTest6 {
	public static void main(String[] args) {
		Person p1 = new Person("김길동", 20);
		Person p2 = (Person)p1.clone();
		
		p1.age = 30;
		p1.name = "하길동";
		
		System.out.println(p1);
		System.out.println(p2);
	}
}


// 이름 : 김길동, 나이 : 20