package test;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamTest1 {
	public static void main(String[] args) {
		int age=20;
		double height=178.5;
		String name="홍길동";
		
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream("info.txt");
			dos = new DataOutputStream(fos);
			dos.writeInt(age);
			dos.writeDouble(height);
			dos.writeUTF(name);
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
