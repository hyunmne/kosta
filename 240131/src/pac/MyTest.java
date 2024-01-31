package pac;

public class MyTest {
	private int x; // 클래스 내에서만 사용 가능
	int y; // 같은 패키지에 있는 클래스에서만 사용 가능
	protected int z; // 패키지가 달라도 자식 클래스에서는 사용 가능
	public int k; // 어디서든 사용 가능
	
	public MyTest() {}
	public void method() {
		x=100;
	}
}
