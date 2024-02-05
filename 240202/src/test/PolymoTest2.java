package test;

class Base {
	
}

class Derived extends Base {
	
}

public class PolymoTest2 {
	Base[] barr = new Base[20];
	int cnt = 0;
	
	void regBase(Base b) {
		barr[cnt++] = b;
	}
	
	public static void main(String[] args) {
		PolymoTest2 pt = new PolymoTest2();
		
		pt.regBase(new Base());
		pt.regBase(new Derived());
		
		
	}
}
