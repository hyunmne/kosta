package test;

class Parent {
	int data1;
	
//	Parent(){} 기본생성자.. 파라미터가 없는 거
	
	void printData() {
		System.out.println(data1);
	}
}

class Child extends Parent {
	int data2;
	
	Child(){}
	
	Child(int x, int y){
		this.data1=x;
		this.data2=y;
	}
	
	@Override
	void printData(){
		System.out.println(data1+", "+data2);
	}

	
}

public class InheritTest4 {
	public static void main(String[] args) {
		Child c1 = new Child();
		c1.data1=10;
		c1.data2=20;
		
		Child c2 = new Child(100,200);
		c1.printData();
		c2.printData();
	}
}
