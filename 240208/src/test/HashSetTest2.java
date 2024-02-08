package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class HashSetTest2 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(6);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(7);
		
		HashSet<Integer> set = new HashSet<>(list);
		System.out.println(set);
		
		TreeSet<Integer> tset = new TreeSet<>();
		tset.add(33);
		tset.add(6);
		tset.add(22);
		tset.add(22);
		tset.add(22);
		tset.add(7);
		
		System.out.println(tset);
	}
}
