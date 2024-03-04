import shape.Shape;

public class ShapeSet {
	
	Shape[] shapes = new Shape[100];
	int cnt;
	
	public void addShape(Shape shape) {
		shapes[cnt++] = shape;
	}

	public void drawAllShapes() {
		for(int i = 0; i < cnt; i++) {
			shapes[i].draw();
		}
	}
}
