package homework;

// 문제6-6에서 작성한 클래스메서드 getDistance()를 MyPoint클래스의 인스턴스메서드로 정의하시오
class MyPoint {
	int x;
	int y;

	MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	double getDistance(int x, int y) {
		double dis;
		
		dis = Math.sqrt((x-this.x)+(y-this.x));
		
		return dis;
	}
}

public class Homework06_07 {
	public static void main(String args[]) {
		MyPoint p = new MyPoint(1,1);
		
		// p(1,1)과 (2,2)의 거리를 구한다.
		System.out.println(p.getDistance(2,2)); 
	}
}
