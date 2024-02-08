package test;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest3 {
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>();
		
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(3));
		
		Iterator<Integer> it = list1.iterator();
		while (it.hasNext()) { // i번쨰 뒤에 데이터가 있는지 없는지
			int n = it.next();
			if(n%2==0) it.remove(); // n이 짝수면 it에서 지워벌임
		}
		for (Integer n : list1) {
			System.out.println(n);
		}
	}
}
