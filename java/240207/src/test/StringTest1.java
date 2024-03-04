package test;

public class StringTest1 {
	public static void main(String[] args) {
		String str1 = "hong";
		String str2 = "hong";
		
		Person p1 = new Person("hong", 20);
		Person p2 = new Person("hong", 20);
		
		System.out.println(p1==p2);
		System.out.println(str1==str2);
		
		String str3 = null;
		String str4 = "";
		
		System.out.println(str4.toString());
	
	}
}
