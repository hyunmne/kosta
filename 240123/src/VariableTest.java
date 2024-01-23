
public class VariableTest {

	public static void main(String[] args) {
		
		boolean isMarried = false;
		char bloodType = 'A';
		int age = 30;
		double height = 161.2;
		float weight = 34.3f;
//		byte b = 128; >> overflow
		String name = "이현민";
				
		System.out.println("나이 : " + age);
		System.out.println("키 : " + height);
		System.out.println("몸무게 : " + weight);
		System.out.println("결혼여부 : " + isMarried);
		System.out.println("혈액형 : " + bloodType);
		System.out.println("이름 : " + name);
		
		name = "이이이"; 
		age = 7;
		System.out.println(age);
		System.out.println(name);
		
		final double pi = 3.14f;
//		pi = 3.141f; >> final은 변경이 안됨.
		
		char ch = 'g';
		char ch2 = ' ';
		String str1 = null;
		String str2 = "";
		
		int value = 10 + 20;
		System.out.println(value);
		
		String str3 = "안녕하세요? ";
		String str4 = "방가방가";
		
		System.out.println(str3+str4);
		
		System.out.println("7"+7+7);
		System.out.println(7+7+"7");
		
		System.out.println(name+", "+age+", "+height+", "+weight);
		
		float f = 1.6f;
		double d = 1.6F;
		double d2 = 3.23;
		
		float f2 = (float)d2; // 강제 형변환 : 특정 데이터나 변수 앞에 일시적으로 타입을 작성하여 형변환 시킴
		
		
	}

}
