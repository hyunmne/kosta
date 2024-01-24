package test;

public class IfTest {
	public static void main(String[] args) {
		int kor = 89;
		int eng = 90;
		int math = 95;
//		int kor = 89, eng = 90, math = 95;
		
		int total = kor + eng + math;
		double avg = total / 3.0; // 소숫점을 살리려면 실수 타입으로 연산해야 됨
		
		System.out.println(Math.round(avg*100)/100d);
	}
}
