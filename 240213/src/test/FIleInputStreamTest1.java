package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FIleInputStreamTest1 {

	public static void main(String[] args) {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		try {
			fis = new FileInputStream("min.jpg");
			fos = new FileOutputStream("min2.jpg");
			
			int data;
			while((data=fis.read())!= -1) { 
				fos.write(data); // min2에 min1을 넣어줌 
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis!=null) fis.close();
				if(fos!=null) fos.close();
			} catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
