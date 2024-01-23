package pratice;

public class pratice10 {
	public static void main(String[] args) {
		char ch = 'A';
		
		char lowerCase = (char) (( (int)ch == 65 ) ? ( (int)ch + 32 ) : ch);
		
		System.out.println("upperCase:"+ch);
		System.out.println("lowerCase:"+lowerCase);
	}
}
