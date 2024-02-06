package chapter05;

// 다음은 알파벳과 숫자를 아래에 주어진 암호표로 암호화하는 프로그램이다.

public class Homework10 {
	public static void main(String[] args) {
		char[] abcCode =  { '`','~','!','@','#','$','%','^','&','*',
							'(',')','-','_','+','=','|','[',']','{',
							'}',';',':',',','.','/'};
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
		
		String src = "abc123";
		String result = "";
		
		// 문자열 src의 문자를 charAt()으로 하나씩 읽어서 변환 후 result에 저장
		for(int i=0; i < src.length();i++) {
			char ch = src.charAt(i);
			if (ch >= 'a' && ch<= 'z') { // ch가 문자일 경우
				result += abcCode[ch-'a'];
			} else { // ch가 숫자일 경우
				result += numCode[ch-'0'];
			}
		}
		
		System.out.println("src:"+src);
		System.out.println("result:"+result);
	}
}
