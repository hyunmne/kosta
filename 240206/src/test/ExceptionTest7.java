package test;

class Exception2 extends Exception{
	Exception2(){
		super("사용자 예외2");
	}
	Exception2(String str){
		super(str);
	}
};

class Exception3 extends Exception2{
	Exception3(){
		super("사용자 예외3");
	}
};

class Exception4 extends Exception{
	Exception4(){
		super("사용자예외4");
	}
}

public class ExceptionTest7 {
	public static void func() throws Exception2{
		throw new Exception2();
	}
	
	public static void func2() throws Exception3{
		throw new Exception3();
	}
	
	public static void func3() throws Exception4{
		throw new Exception4();
	}
	
	public static void main(String[] args) {
		
		try {
			func();
			func2();
			func3();
		} catch (Exception3 e) { // 예외도 상속관계에 있으면 자식 catch가 먼저 와야 함
			System.out.println("func2의 대체 처리");
		} catch (Exception2 e) {
			System.out.println("func의 대체 처리");
		} catch (Exception4 e) { // 상속관계에 속하지 않기 때문에 위치 상관 없음.
			System.out.println("func3의 대체 처리");
		}
	}
}
