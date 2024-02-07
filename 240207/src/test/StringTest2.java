package test;

public class StringTest2 {
	public static void main(String[] args) {
		String str1 = "hong";
		String str2 = new String(str1);
		
		// char 배열로 String을 생성할 수 있다.
		char[] carr = {'h', 'o', 'n', 'g'};
		String str3 = new String(carr);
		
		StringBuffer sb = new StringBuffer("hong");
		String str4 = new String(sb);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		for(int i=0; i<str1.length(); i++) {
			char ch = str1.charAt(i);
			System.out.println(ch);
		}
		
		String str5 = "gildong";
		String name = str1.concat(str5); // str1 + str5 
		System.out.println(name);
		
		String str6 = "사과, 바나나, 오렌지, 딸기";
		boolean apple = str6.contains("사과"); // 해당 문자열이 포함돼있는지 아닌지
		System.out.println(apple);
		
		String[] files = {"test.txt", "test2.png", "test3.jpg", "test4.png"};
		for (int i=0; i<files.length; i++) {
			// 문자열의 끝이 jpg로 끝이 나는지 판단.
			if (files[i].endsWith("jpg")) {
				System.out.println(files[i]);
			}
		}
		System.out.println("----------------");
		for (int i=0; i<files.length; i++) {
			// 문자열의 끝이 jpg로 시작하는지 판단.
			if (files[i].startsWith("test")) {
				System.out.println(files[i]);
			}
		}
		
		
	}
}
