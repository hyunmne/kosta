package com.test02;

import java.util.ArrayList;

public class TestStudent {
	public static void main(String[] args) {
		
		Student s1 = new Student("홍길동", 20, 177, 74, "201301", "체육");
		Student s2 = new Student("이순신", 44, 178, 77, "201302", "체육");
		Student s3 = new Student("유관순", 18, 155, 45, "201303", "컴퓨터");
		
		ArrayList<Student> std = new ArrayList<>();
		std.add(s1);
		std.add(s2);
		std.add(s3);
		
		for (Student s : std) {
			System.out.println(s);
		}
		
	}
}
