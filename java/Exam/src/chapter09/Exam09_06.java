package chapter09;

public class Exam09_06 {
	public static String fillZero(String src, int length) {
		/* (1) fillZero메서드를 작성하시오.
		1. src가 널이거나 src.length()가 length와 같으면 src를 그대로 반환한다.
		2. length의 값이 0보다 같거나 작으면 빈 문자열("")을 반환한다.
		3. src의 길이가 length의 값보다 크면 src를 length만큼 잘라서 반환한다.
		4. 길이가 legnth인 char배열을 생성핞다.
		5. 4에서 생성한 char배열을 '0'으로 채운다.
		6. src에서 문자배열을 뽑아내서 4에서 생성한 배열에 복사한다.
		7. 4에서 생성한 배열로 String을 생성해서 반환한다.
		 */
		
		if (src==null || src.length()==length) return src;
		if (length <= 0) return "";
		if (src.length() > length) return src.substring(0, length);
		
		char[] carr = new char[length];
		for (int i=0; i<carr.length; i++) {
			carr[i] = '0';
		}
//		for(int i=length-src.length(), j=0; i<length; i++, j++) {
//			carr[i] = src.charAt(j);
//		}
		System.arraycopy(src.toCharArray(), 0, carr, length-src.length(), src.length());
		
		String str = new String(carr);
		return str;
	}
	
	public static void main(String[] args) {
		String src = "123456";
		System.out.println(fillZero(src,10));
		System.out.println(fillZero(src,-1));
		System.out.println(fillZero(src,3));
	}
}
