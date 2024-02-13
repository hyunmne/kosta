package test;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataStreamTest2 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			fis = new FileInputStream("info.txt");
			dis = new DataInputStream(fis);
			int age = dis.readInt();
			double height = dis.readDouble();
			String name = dis.readUTF(); // 문자열은 UTF
			dis.close();
			System.out.println(age);
			System.out.println(height);
			System.out.println(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
