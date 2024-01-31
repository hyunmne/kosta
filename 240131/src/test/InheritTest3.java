package test;

class Point {
	int x;
	int y;
	
	Point(){ // 자식생성자보다 먼저 호출된다.
		System.out.println("Point default constructor");
	}
	
	Point(int x, int y) {
		this.x=x;
		this.y=y;
	}

	String getLocation() {
		return "("+x+", "+y+")";
	}
}

class Point3D extends Point {
	int z;
	
	Point3D(){
		System.out.println("Point3D default constructor");
	}
	
	Point3D(int x, int y, int z) {
		super(x, y);
		this.z =z;
	}

	@Override
	String getLocation() {
		return "("+x+", "+y+", "+z+")";
	}
}

public class InheritTest3 {
	public static void main(String[] args) {
//		Point p2 = new Point(10,20);
//		System.out.println(p2.getLocation());
		
		Point3D p3 = new Point3D(100,200,300);
		System.out.println(p3.getLocation());
	}

}
