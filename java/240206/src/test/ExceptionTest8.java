package test;

public class ExceptionTest8 {
	public static void main(String[] args) {
		try {
			String str = "hong";
			System.out.println(str.toString());
		} catch(NullPointerException e) {
			System.out.println(e.getMessage());
		} finally { // try든 catch든 마지막에 공통으로 처리해야 할 문장
			System.out.println("마무리 처리");
		}
	}
}
