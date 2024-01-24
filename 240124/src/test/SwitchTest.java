package test;

public class SwitchTest {
	public static void main(String[] args) {
		int val1 = 3, val2 = 5, result=0;
		char op = '+';
		
		switch(op) {
		case '+': result = val1 + val2; break;
		case '-': result = val1 - val2; break;
		case '*': result = val1 * val2; break;
		case '/': result = val1 / val2; break;
		}
		System.out.println(result);
	
	}
}
