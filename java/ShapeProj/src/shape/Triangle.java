package shape;

public class Triangle extends Shape {
	Point p1;
	Point p2;
	Point p3;

	public Triangle() {}
	
	public Triangle(String color, int x1, int y1, int x2, int y2, int x3, int y3) {
		super(color);
		p1 = new Point(x1, y1);
		p2 = new Point(x2, y2);
		p3 = new Point(x3, y3);
	}

	public Triangle(String color, Point p1, Point p2, Point p3) {
		super(color);
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	public Point getP1() {
		return p1;
	}

	public Point getP2() {
		return p2;
	}

	public Point getP3() {
		return p3;
	}

//	@Override
//	public String toString() {
//		return "[삼각형-색:" + color + ", 점1" + getP1() + ", 점2" + getP2() + ", 점3" + getP3() + "]";
//	}

	@Override
	public void draw() {
		System.out.println("[삼각형-색:" + color + ", 점1" + getP1() + ", 점2" + getP2() + ", 점3" + getP3() + "]");
		
	}
}
