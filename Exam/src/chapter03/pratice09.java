package chapter03;

public class pratice09 {
	public static void main(String[] args) {
		char ch = 'z';
		boolean b = (ch >= 'a' && ch<= 'z') || (ch >='A'&& ch <= 'Z') || (ch >='0'&& ch <= '9');
		
		System.out.println(b);
	}
}
