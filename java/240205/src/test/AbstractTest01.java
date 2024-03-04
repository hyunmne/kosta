package test;

abstract class Player{ // abstract method를 하나라도 포함한 클래스는 abstract 클래스여야 한다.
	int currentPos;
	Player(){
		currentPos = 0;
	}
	abstract void play(int pos); // abstract method는 구현부가 없다.
	abstract void stop();
	void play() {
		play(currentPos); // 20번째 라인 호출
	}
	
	
}

class MyPlayer extends Player {

	@Override
	void play(int pos) {
		System.out.println("play");
	}
	@Override
	void stop() {
		System.out.println("stop");
	}
	
}

public class AbstractTest01 {
	public static void main(String[] args) {
//		Player p1 = new Player(); // abstract class는 객체 생성이 불가능하다.
		Player p1 = new MyPlayer();
		p1.play(); // 10번째 라인 호출
		p1.stop(); // 24번째 라인 호출
	}
}
