package chapter06;

// 다음 코드의 실행 결과를 예측하여 적으시오.
public class Homework06_19 {
	
	public static void change(String str) {
		str += "456";
	}
	
	public static void main(String[] args) {
		String str = "ABC123";
		String str1 = str;
		str += "456";
		String str2 = str;
		System.out.println(str1 == str2); // 주솟값이 다름
		
		System.out.println(str);
		change(str);
		System.out.println("After change:"+str);
	}
}

// ABC123 
// After change: 456

/*
	라고 예상했으나!!!!!! 정답은
	ABC123
	After change : ABC123
	였다..
	
	왠지 생각해보니까 static이 있어서 값이 안 변했던 것 같음 
	>> 이것도 아니고 change 메소드에서 str이 ABC123456으로 변하지만 그저 새로운 문자열이 생긴 것 뿐이라내요,,
*/