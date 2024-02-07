package chapter09;

/*
 * 다음과 같이 정의된 메서드를 작성하고 테스트하시오. 
	 메서드명 : format
	 기 능 : 주어진 문자열을 지정된 크기의 문자열로 변환한다. 나머지 공간은 공백으로 채운다.
	 반환타입 : String
	 매개변수 : String str - 변환할 문자열
	 int length - 변환된 문자열의 길이
	 int alignment - 변환된 문자열의 정렬조건
	 (0:왼쪽 정렬, 1: 가운데 정렬, 2:오른쪽 정렬)
 */

public class Exam09_10 {

	static String format(String str, int length, int alignment) {


		if (length < str.length()) return str.substring(0, length);
		
		char[] carr = new char[length];
		for(int i=0; i<carr.length; i++) {
			carr[i] = ' ';
		}
		
		int startIdx;
		if (alignment == 0) {
			startIdx = 0;
		} else if (alignment == 1) {
			startIdx = (length-str.length())/2;
		} else {
			startIdx = length-str.length();
		}

		System.arraycopy(str.toCharArray(), 0, carr, startIdx, str.length());
		
		return new String(carr);
	}

	public static void main(String[] args) {
		String str = "가나다";
		System.out.println(format(str,7,0)); // 왼쪽 정렬
		System.out.println(format(str,7,1)); // 가운데 정렬
		System.out.println(format(str,7,2)); // 오른쪽 정렬
	}
}
