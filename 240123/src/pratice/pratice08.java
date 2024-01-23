package pratice;

public class pratice08 {
	public static void main(String[] args) {
		byte a = 10;
		byte b = 20;
		byte c = (byte) (a+b);
		
		char ch = 'A';
		int ch1 = (int)ch + 2;
		ch = (char)ch1;
		
		float f = 3 / 2f;
		
		long l = 3000 * 3000 * 3000l;
		
		float f2 = 0.1f;
		double d = (float)0.1;
		
		boolean result = d==f2;
		
		System.out.println("c="+c);
		System.out.println("ch="+ch);
		System.out.println("f="+f);
		System.out.println("l="+l);
		System.out.println("result="+result);
	}
}
