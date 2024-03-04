package pac;

public class Point {
	int x;
	int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Point (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return String.format("[%d, %d]", x,y);
	}

	@Override
	public Object clone() {
//		return String.format("이름 : %d, 나이 : %d", x, y);
		return new Point(x, y);
	}
}
