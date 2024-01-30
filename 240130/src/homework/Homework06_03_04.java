package homework;


class Student {
	// 6-3번
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	// 6-4번
	int getTotal() {
        int sum = kor + eng + math;
        return sum;
    }

    float getAverage() {
        int sum = getTotal();
        float avg = (float) sum / 3;
        return (float)(Math.round(avg * 10.0) / 10.0);
    }

}

public class Homework06_03_04 {
	public static void main(String args[]) {
		Student s = new Student();
		s.name = "홍길동";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;
		
		System.out.println("이름:"+s.name);
		System.out.println("총점:"+s.getTotal());
		System.out.println("평균:"+s.getAverage());
		
	}

}
