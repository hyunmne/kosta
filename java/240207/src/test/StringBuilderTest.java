package test;

public class StringBuilderTest {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("string");
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		sb.reverse();
//		sb.replace(3, 4, "o");
		sb.setCharAt(3, 'o');
		System.out.println(sb);
//		sb.setLength(5); // 자르기..
//		System.out.println(sb);
	}
}
