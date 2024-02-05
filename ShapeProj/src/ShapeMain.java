import shape.Circle;
import shape.Point;
import shape.Rectangle;
import shape.Triangle;

public class ShapeMain {
	public static void main(String[] args) {
		ShapeSet ss = new ShapeSet();
		ss.addShape(new Circle("빨강", 10, 10, 20));
		ss.addShape(new Circle("주황", new Point(5, 5), 10));
		ss.addShape(new Triangle("파랑", 3, 3, 10, 10, 5, 5));
		ss.addShape(new Triangle("하늘", new Point(2, 2), new Point(8, 8), new Point(4, 4)));
		ss.addShape(new Rectangle("초록", 2, 2, 30, 15));
		ss.addShape(new Rectangle("연두", new Point(6, 6), 30, 10));
		ss.drawAllShapes();
	}
}

//[원-중심점:(10,10), 반지름:20]
//[원-중심점:(5,5), 반지름:10]
//[삼각형-점1:(3,3), 점2(10,10), 점3(5,5)]
//[삼각형-점1:(2,2), 점2(8,8), 점3(4,4)]
//[사각형-시작점:(2,2), 가로:30, 세로:15]
//[사각형-시작점:(6,6), 가로:20, 세로:10]