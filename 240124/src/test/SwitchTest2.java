package test;

public class SwitchTest2 {
	public static void main(String[] args) {
		int kor = 89;
		int eng = 90;
		int math = 95;
//		int kor = 89, eng = 90, math = 95;
		char grade;
	
		int total = kor + eng + math;
		double avg = total / 3.0; // 소숫점을 살리려면 실수 타입으로 연산해야 됨
		avg = Math.round(avg*100)/100d;

		
		switch((int)(avg/10)) {
		case 10: 
		case 9: grade = 'A'; break;
		case 8: grade = 'B'; break;
		case 7: grade = 'C'; break;
		case 6: grade = 'D'; break;
		default : grade = 'F'; break;
		}
			
		
		System.out.println(
				String.format("총점 : %d, 평균 : %.2f, 학점 : %c", total, avg, grade));
	
	}
}
