package test;

public class IfTest {
	public static void main(String[] args) {
		int kor = 89;
		int eng = 90;
		int math = 95;
//		int kor = 89, eng = 90, math = 95;
		char grade;
	
		int total = kor + eng + math;
		double avg = total / 3.0; // 소숫점을 살리려면 실수 타입으로 연산해야 됨
		avg = Math.round(avg*100)/100d;
		
		if (avg >= 90) {
			grade = 'A';
		} else if (avg >= 80) {
			grade = 'B';
		} else if (avg >= 70) {
			grade = 'C';
		} else if (avg >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		
		System.out.println(
				String.format("총점 : %d, 평균 : %.2f, 학점 : %c", total, avg, grade));
		
	}
}
