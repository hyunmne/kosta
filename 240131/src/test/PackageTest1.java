package test;

import pac.MyTest;

class Person1 {
	private int age;
	public void setAge(int age) {
		if (age>0)
			this.age = age;
	}
	
	public int getAge() {
		return age;
	}
}

public class PackageTest1 {
	public static void main(String[] args) {
		MyTest mt = new MyTest();
//		mt.x = 10; // 클래스가 달라서 사용할 수 없음.
//		mt.y = 20; // 패키지가 달라서 사용할 수 없음.
//		mt.z=30; // 상속 관계가 아니라서 사용할 수 없음.
		mt.k = 40;
		
		Person1 p1 = new Person1();
		
		p1.setAge(10);
		System.out.println(p1.getAge());
	}
}
