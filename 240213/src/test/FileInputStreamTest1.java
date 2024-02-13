package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamTest1 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
//			fis = new FileInputStream("min.jpg");
//			fos = new FileOutputStream("min2.jpg");

			fis = new FileInputStream("text.txt");  //파일에서 byte단위의 데이터 읽어오기
			fos = new FileOutputStream("text2.txt");  //파일에 byte단위의 데이터 생성 후 저장
			
			byte[] buff = new byte[1024];
			int len;

//			int data;
//			while((data=fis.read())!= -1) { 
//				fos.write(data); // min2에 min1을 넣어줌 
//			}

			while((len = fis.read(buff)) > 0) { 
				fos.write(buff, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) fis.close();
				if(fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
