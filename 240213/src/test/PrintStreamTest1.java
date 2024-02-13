package test;

public class PrintStreamTest1 {
	public static void main(String[] args) {
		String name = "이현민";
		int age = 24;
		double height = 162.1;
		
		// %.1f >> 소수점 첫째자리 반올림
		System.out.printf("이름:%s, 나이:%d, 키:%.1f", name, age, height);
		System.out.println();
	}
}
