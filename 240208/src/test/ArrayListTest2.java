package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListTest2 {
	
	static void print(ArrayList<Integer> list) {
		for(Integer n : list) {
			System.out.print(n+", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>(10);
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(3));
		
		ArrayList<Integer> list2 = new ArrayList<>(list1.subList(1, 3));
		print(list1);
		print(list2);
		
		Collections.sort(list1);
		print(list1);
		System.out.println(list1.containsAll(list2));
		System.out.println(list1.contains(3));
		list1.remove(0);
		print(list1);
		list1.remove(new Integer(5));
		print(list1);
		
		System.out.println(list1.size());
		list1.retainAll(list2); // list1에서 list2에 있는 걸 남기고 나머지 삭제
		System.out.println(list1); 
		list1.clear(); // list1 전부 비우기
		System.out.println(list1.size()); // list1의 사이즈
		System.out.println(list1.isEmpty()); // 비어있는지
	}
}
