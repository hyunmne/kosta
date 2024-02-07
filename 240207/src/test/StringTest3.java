package test;

public class StringTest3 {
	public static void main(String[] args) {
		String str = "abcdefg";
		int idx1 = str.indexOf('c'); // 해당 문자의 문자열 순번
		System.out.println(idx1);
		int idx2 = str.indexOf("de"); // 첫번째 d의 순번을 받아옴 
		System.out.println(idx2);
		int idx3 = str.indexOf("h"); // 문자열에 해당 문자가 없으면 -1 
		System.out.println(idx3);
		
		int idx4 = str.lastIndexOf("ab");
		System.out.println(idx4);
		
		String str2 = "Hello";
		String str3 = str2.replace('H', 'C'); // H를 C로 변경 
		System.out.println(str2);
		System.out.println(str3);
		String str4 = str.replace("abc", "ABC");
		System.out.println(str4);
		
		String info = "홍길동,20,사회학과";
		String[] infos = info.split(","); // ,를 기준으로 자름
		System.out.println(infos.length);
		System.out.println(infos[0]);
		System.out.println(infos[1]);
		System.out.println(infos[2]);
		System.out.println("---------------");
		String[] infos2 = info.split(",",2); // 지정한 갯수만큼 자를 수 있음.
		for(int i=0; i<infos2.length; i++) {
			System.out.println(infos[i]);
		}
		
		String str5 = "java.lang.String";
		String str6 = str5.substring(5); // 지정 인덱스 뒤의 문자열만 가지고 옴
		System.out.println(str6);
		String str7 = str5.substring(5,9); // 5 < < 9 사이의 문자열 인덱스만 가져옴
		System.out.println(str7);
		
		String str8 = str2.toLowerCase(); // 소문자
		String str9 = str2.toUpperCase(); // 대문자 
		System.out.println(str8);
		System.out.println(str9);
		
		String str10 = " string ";
		String str11 = str10.trim(); // 공백 제외 문자열 길이
		System.out.println(str10.length());
		System.out.println(str11.length());
		
		String ten = String.valueOf(10); 
		String tru = String.valueOf(false);
		String per = String.valueOf(new Person("park",30));
		System.out.println(ten);
		System.out.println(tru);
		System.out.println(per);
	
	}
}
