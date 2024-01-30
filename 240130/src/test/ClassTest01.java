package test;

// class 정의
class Person { // 클래스의 정의는 밖에다가 함
	int age;
	String name;
	
	String info() {
		return "이름: " +name+", 나이: "+age;
	}
	
	Person() {} // 기본 생성자 : 아무것도 없는 것
	
	Person(int a, String n) { // 생성자 
		age = a;
		name = n;
	}
	
}

public class ClassTest01 {
	public static void main(String[] args) {
		Person p1 = new Person(); // 객체 또는 인스턴스
		p1.age = 30;
		p1.name = "홍길동";
		
		Person p2 = new Person(); 
		p2.age = 20;
		p2.name = "고길동";
		
		Person p3 = new Person(25, "홍길동");
		Person p4 = new Person(30, "고길동");
		
		System.out.println(p1.info());
		System.out.println(p2.info());
		System.out.println(p3.info());
		
		Person[] pers = new Person[3]; // Person 타입의 배열 생성 
		pers[0] = new Person();
		
		
		
	}
}
