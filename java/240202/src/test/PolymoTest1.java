package test;

class Person {
	int age;
	String name;
	
	Person() {}
	Person(String naem, int age){
		this.name = naem;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "이름:" + name + ", 나이:" + age;
	}
}

class Student extends Person {
	String major;
	Student(String name, int age, String major){
		super(name, age);
		this.major = major;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", 전공:" + major;
	}
	
	public String getMajor() {
		return major;
	}
}


public class PolymoTest1 {
	public static void main(String[] args) {
		
		//(메모리 구조는 똑같고) 자식 객체의 타입을 부모 타입으로 설정하는 것
		Student s1 = new Student("홍길동", 20, "사회심리학");  //부모, 자식 모두 접근 가능
		System.out.println(s1.toString());
		System.out.println(s1.getMajor());
		
		Person s2 = new Student("김길동", 30, "인지심리학");  //upcasting (자식에만 있는 건 접근 불가)
		System.out.println(s2.toString());  //new한 자식에서 오버라이딩한 기능 호출 
		
		// ★ 다형성 ★
		//각 요소들이 여러가지 자료형으로 표현될 수 있다는 것
//		System.out.println(s2.major);  //자료형이 부모타입이면 아무리 자식 객체를 생성했더라도 부모의 것만 접근할 수 있다. => s2로는 자식에만 있는 major에 접근 불가
//		System.out.println(s2.getMajor());  //자식 객체를 부모변수에 담았을 경우 자식에만 있는 기능을 호출할 수 없다.
		System.out.println(s2.toString());  //단, 부모타입의 변수라 하더라도 오버라이딩한 기능은 new 한 자식의 기능을 호출한다.
	}
}




