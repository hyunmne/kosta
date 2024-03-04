package chapter07;

abstract class Unit{
	int x,y;
	abstract void move(int x, int y); //추상클래스
	void stop(){/*현재 위치에 정지*/}
}

class Marine extends Unit{ // 현재 위치
	void move(int x, int y){
		System.out.println("("+x+","+y+")까지 걸어간다..");
	}; 
	void stimPack()  { /* 스팀팩을 사용한다.*/} 
} 


class Tank extends Unit{ //탱크 
	void move(int x, int y){
		System.out.println("("+x+","+y+")까지 굴러간다..");
	}; 
	void changeMode()  { /* 공격모드를 변환한다. */} 
} 

class Dropship extends Unit{ //수송선 
	void move(int x, int y){
		System.out.println("("+x+","+y+")까지 헤엄쳐간다..");
	};
	void load()  { /* 선택된 대상을 태운다.*/ } 
	void unload()  { /* 선택된 대상을 내린다.*/ } 
}


public class Homework07_17 {
	public static void main(String[] args) {
		Unit[] group = new Unit[4];
		group[0] = new Tank();
		group[1] = new Marine();
		group[2] = new Dropship();
		group[3] = new Marine();

		for (int i=0; i<group.length; i++) {
			group[i].move(100,200);
		}
	}
}

// (100,200)까지 굴러간다.
// (100,200)까지 걸어간다.
// (100,200)까지 헤엄쳐간다.
// (100,200)까지 걸어간다.
