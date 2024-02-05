package shape;

public class Circle extends Shape {
	
	Point center;
	int radius;
	
	public Circle() {}
	
	public Circle(String color, int x, int y, int radius) {
		super(color);
		center = new Point(x, y);
		this.radius = radius;
	}

	public Circle(String color, Point point, int radius) {
		super(color);
		this.center = point;
		this.radius = radius;
	}

	public Point getCenter() {
		return center;
	}

	public int getRadius() {
		return radius;
	}
	
//	@Override
//	public String toString() {
//		return "[원-색:" + color + ", 중심점:" + getCenter() + ", 반지름:" + getRadius() + "]";
//	}

	@Override
	public void draw() {
		System.out.println("[원-색:" + color + ", 중심점:" + getCenter() + ", 반지름:" + getRadius() + "]");
	}

}
