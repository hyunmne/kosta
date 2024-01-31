package homework;

public class Homework06_05 {
	public static void main(String args[]) {
		Student1 s = new Student1("홍길동",1,1,100,60,76);
		System.out.println(s.info());
	}
}

class Student1 {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int sum;
	float avg;

	int getTotal() {
        int sum = kor + eng + math;
        return sum;
    }

    float getAverage() {
        return (Math.round(getTotal()/3f * 10.0) / 10.0f);
    }
    
	Student1(String name, int ban, int no, int eng, int kor, int math){
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.eng=eng;
		this.kor=kor;
		this.math=math;
		
		sum = getTotal();
		avg = getAverage();
	}

	String info() {
		return name+", "+ban+", "+no+", "+eng+", "+kor+", "+math+", "+sum+", "+avg;
	}

}
