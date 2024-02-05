package homework;

/*
 아래는 도형을 정의한 Shape클래스이다. 
 이 클래스를 조상으로 하는 Circle 클래스와 Rectangle 클래스를 작성하시오. 
 이 때, 생성자도 각 클래스에 맞게 적절히 추가해야 한다.
 
(1)  클래스명 : Circle
	 조상클래스 : Shape
	 멤버변수 : double r - 반지름
	 
(2)  클래스명 : Rectangle
	 조상클래스 : Shape
	 멤버변수 : int width - 폭
	 		 int height - 높이
	 메서드 : 
		1. 메서드명 : isSquare
		 기 능 : 정사각형인지 아닌지를 알려준다.
		 반환타입 : boolean
		 매개변수 : 없음
 */
abstract class Shape {
	Point p;
	Shape() {
		this(new Point(0,0));
	}
	Shape(Point p) {
		this.p = p;
	}
	
	abstract double calcArea(); // 도형의 면적을 계산해서 반환하는 메서드
	
//	Point getPosition() {
//		return p;
//	}
//	void setPosition(Point p) {
//		this.p = p;
//	}
}

class Point {
	int x;
	int y;
	Point() {
		this(0,0);
	}
	Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public String toString() {
		return "["+x+","+y+"]";
	}
}

class Circle extends Shape {
	double r;
	
	public Circle(Point point, double r) {
		this.p = point;
		this.r = r;
	}

	public Circle(double d) {
		this.r = d;
	}

	@Override
	double calcArea() {
		return r*r*Math.PI;
	}
	
}

class Rectangle extends Shape {
	int width;
	int height;
	
	public Rectangle(Point point, int width, int height) {
		this.height = height;
		this.width = width;
		this.p = point;
	}

	public Rectangle(int width, int height) {
		this.height = height;
		this.width = width;
	}

	@Override
	double calcArea() {
		return width*height;
	}
	
	boolean isSquare() {
		if (width == height) {
			return true;
		}
		return false;
	}
	
}

public class Homework07_22 {
	
	public static double sumArea(Shape[] arr) {
		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i].calcArea();
		}
		return sum;

	}
	
	public static void main(String[] args) {
		Shape[] ss = new Shape[4];
		
		ss[0] = new Circle(new Point(5,5), 10);
		ss[1] = new Circle(20);
		ss[2] = new Rectangle(new Point(3,3), 20, 10);
		ss[3] = new Rectangle(30, 10);
		
		for (int i=0; i<ss.length; i++) {
			System.out.println(ss[i].calcArea());
		}
//		System.out.println("면적의 합 : " + sumArea(ss));
		
		Shape[] arr = { new Circle(5.0), new Rectangle(3, 4), new Circle(1) };
		System.out.println("면적의 합 : " + sumArea(arr));
	}

}
