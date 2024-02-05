package shape;

public class Rectangle extends Shape {
	
	Point startPos;
	int width;
	int height;
	
	public Rectangle() {}
	
	public Rectangle(String color, int x, int y, int width, int height) {
		super(color);
		startPos = new Point(x, y);
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(String color, Point startPos, int width, int height) {
		super(color);
		this.startPos = startPos;
		this.width = width;
		this.height = height;
	}
	
	public Point getStartPos() {
		return startPos;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

//	@Override
//	public String toString() {
//		return "[사각형-색:" + color + ", 시작점" + getStartPos() + ", 가로:" + getWidth() + ", 세로:" + getHeight() + "]";
//	}

	@Override
	public void draw() {
		System.out.println("[사각형-색:" + color + ", 시작점" + getStartPos() + ", 가로:" + getWidth() + ", 세로:" + getHeight() + "]");
	}
	
}
