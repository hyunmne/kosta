package test;

class Person{
	int age;
	String name;
	
	String info() {
		return "이름 : " + name + ", 나이 : " + age;
	}
}

class Student extends Person {
	int grade;
	String major;
	
	void test() {
		System.out.println("시험보다");
	}

	@Override // 오버라이드 재정의
	String info() {
		return super.info()+", 학년 : " +grade+", 전공 : "+major;
	}
	
}

public class InheritTest1 {
	public static void main(String[] args) {
		Student s = new Student();
		s.age = 20;
		s.grade = 1;
		s.major = "산업디자인";
		s.name = "홍길동";
		
		System.out.println(s.info());
		s.test();
		
	}
}
