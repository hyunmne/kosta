package test;

import java.util.ArrayList;

class Person {
	String name;
	int age;
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String info() {
		return "이름 : "+name+", 나이 :"+age;
	}
}

public class ArrayListTest1 {
	public static void main(String[] args) {
		// arrList의 데이터 타입을 Person으로 지정.
		ArrayList<Person> al = new ArrayList<>();
		al.add(new Person("hong", 20));
		al.add(new Person("song", 20));
		al.add(new Person("gong", 20));
		
//		for (int i=0; i<al.size(); i++) {
//			// arrayList에서 데이터를 가져오는 메소드는 get
//			System.out.println(al.get(i)); 
//		}
		
//		for(Object o : al) { // for-each문
//			System.out.println(((Person)o).info());
//		}
		
		for(Person p : al) { // for-each문
			System.out.println(p.info());
		}
	}
}
