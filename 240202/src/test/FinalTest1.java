package test;

class Product {
	static int cnt;
	final int serialNo;  //instance final 변수는 생성자에서 초기화한다.
	
	Product() {
		serialNo = cnt++;
	}
	
	Product(int serialNo) {
		this.serialNo = serialNo;
	}
}

public class FinalTest1 {
	public static void main(String[] args) {
		int n = 10;
		n = 20;
		
		final double pi = 3.141592;  //변경할 수 없음
		
	}
}
