package test;

class Complex {
	int real;
	int imaginary;
	
	Complex(int real, int imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Complex)) return false;
		Complex com = (Complex) obj;
		return real == com.real && imaginary==com.imaginary;
	}
}

public class ObjectTest2 {
	public static void main(String[] args) {
		Complex c1 = new Complex(3,5);
		Complex c2 = new Complex(3,5);
		Complex c3 = new Complex(5,3);
		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));
	}
}
