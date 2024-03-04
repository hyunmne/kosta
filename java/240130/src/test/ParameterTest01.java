package test;

class Data {
	int n;
}

public class ParameterTest01 {
	
	public static void plusData(int d) {
		d++;
		System.out.println(d);
	}
	
	public static void plusData(Data d) {
		d.n++;
		System.out.println(d.n);
	}

	public static void main(String[] args) {
		Data data = new Data();
		data.n = 100;
		plusData(data.n);
		System.out.println(data.n);
		System.out.println("==============");
		plusData(data); // 1
		System.out.println(data.n);
		System.out.println("==============");
		
		Data data2 = data; // 2
		data2.n++;
		System.out.println(data2.n);
		System.out.println(data.n);
	}
}
