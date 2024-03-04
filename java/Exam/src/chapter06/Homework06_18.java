package chapter06;

//  다음의 코드를 컴파일 하면 에러가 발생한다. 컴파일 에러가 발생하는 라인과 그 이유를 설명하시오.
public class Homework06_18 {

}

class MemberCall {
	int iv = 10;
	static int cv = 20;
	
	int iv2 = cv;
//	static int cv2 = iv; // 라인 A : static에서 인스턴스를 초기화 할 수 없다.
	
	static void staticMethod1() {
		System.out.println(cv);
//		System.out.println(iv); // 라인 B : 정적 메서드에서는 인스턴스 메소드를 참조할 수 없다.
	}
	
	void instanceMethod1() {
		System.out.println(cv);
		System.out.println(iv); // 라인 C
	}
	
	static void staticMethod2() {
		staticMethod1();
//		instanceMethod1(); // 라인 D : 정적 메소드에서는 인스턴스 메소드를 호출할 수 업삳.
	}
	
	void instanceMethod2() {
		staticMethod1(); // 라인 E
		instanceMethod1();
	}
}

// 라인 A B D
