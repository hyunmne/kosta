package test;

import java.util.Comparator;
import java.util.TreeSet;

class Student {
	String name;
	int ban;
	int no;
	int kor, eng, math;
	
	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	int getTotal() {
		return kor+eng+math;
	}
	float getAverage() {
		return (int)((getTotal()/ 3f)*10+0.5)/10f;
	}
	public String toString() {
		return name +","+ban +","+no +","+kor +","+eng +","+math
				+","+getTotal() +","+getAverage();
	}
}

public class TreeSetTest2 {
	public static void main(String[] args) {
		Comparator<Student> comparator = new Comparator<Student>() {
			public int compare(Student o1, Student o2) {
				if (o1.ban>o2.ban) return 1;
				else if (o1.ban<o2.ban) return 1;
				else {
					return o1.no - o2.no;
				}
//				return o2.getTotal() - o1.getTotal();
			}
		};
		
		TreeSet<Student> tset = new TreeSet<>(comparator);
		tset.add(new Student("홍길동",1,2,100,100,100));
		tset.add(new Student("남궁성",1,3,90,70,80));
		tset.add(new Student("김자바",2,2,80,80,90));
		tset.add(new Student("이자바",2,1,70,90,70));
		tset.add(new Student("안자바",1,2,60,100,80));
		
		for (Student s : tset) {
			System.out.println(s);
		}
	}
}
