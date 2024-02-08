package test;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest1 {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<>();
		
		v.add(new Integer(5));
		v.add(new Integer(4));
		v.add(new Integer(2));
		v.add(new Integer(0));
		v.add(new Integer(3));
		
		Enumeration<Integer> e = v.elements();
		while(e.hasMoreElements()) {
			int n = e.nextElement();
			System.out.println(n);
		}
	}
}
