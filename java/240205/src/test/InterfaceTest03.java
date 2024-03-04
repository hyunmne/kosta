package test;

interface Movable {
	void move();
}

class Car {
	void transfer(Movable m) {
		if (m!=null) {
			m.move();
		}
	}
}

public class InterfaceTest03 {
	public static void main(String[] args) {
		Car car = new Car();
		car.transfer(new Movable() {
			@Override
			public void move() {
				System.out.println("자동차가 이동한다.");
			}
		});
	}
}

// 자동차가 이동한다.
