package test;

import java.util.TreeSet;

public class TreeSetTest1 {
	public static void main(String[] args) {
		TreeSet<String> tset = new TreeSet<>();
		tset.add("홍길동");
		tset.add("박길동");
		tset.add("홍하동");
		tset.add("조길순");
		tset.add("박상동");
		tset.add("고만순");
		System.out.println(tset);
		
		TreeSet<Person> pset = new TreeSet<>();
		pset.add(new Person("홍길동",10));
		pset.add(new Person("박길동",50));
		pset.add(new Person("홍하동",20));
		pset.add(new Person("조길순",30));
		pset.add(new Person("박상동",60));
		pset.add(new Person("고만순",40));
		System.out.println(pset);
	}                                   
}
