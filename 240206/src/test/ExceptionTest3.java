package test;

public class ExceptionTest3 {
	public static void main(String[] args) {
		String str = "";
		// && 연산은 앞의 연산 결과가 거짓이면 뒤에 있는 연산을 하지 않는다.
		// || 연산은 앞의 연산 결과가 참이면 뒤에 있는 연산을 하지 않는다.
		if(str!=null && !str.equals("")) { 
//		if(!str.equals("") && str!=null) {
			System.out.println("AAA");
		}
	}
}
