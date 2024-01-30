package homework;

public class Homework06_05 {
	public static void main(String args[]) {
		Student1 s = new Student1("홍길동",1,1,100,60,76);
		System.out.println(s.info());
	}
}

class Student1 {
	String name;
	int a;
	int b;
	int eng;
	int kor;
	int math;
	int sum;
	float avg;

	Student1(String name, int a, int b, int eng, int kor, int math){
		this.name = name;
		this.a = a;
		this.b = b;
		this.eng=eng;
		this.kor=kor;
		this.math=math;
		
		sum = eng + kor + math;
		avg = (float) (Math.round((sum/3)*10.0)/10.0);
	}

	String info() {
		return name+", "+a+", "+b+", "+eng+", "+kor+", "+math+", "+sum+", "+avg;
	}

}
