package chapter03;

public class pratice07 {
	public static void main(String[] args) {
		int fahrenheit = 100;
		float celcius = (5/9f * (fahrenheit-32));
		
		System.out.println("Fahrenheit:"+fahrenheit);
		System.out.println("Celcius:"+String.format("%.2f",celcius));
	}

}
