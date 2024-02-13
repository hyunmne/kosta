package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamTest1 {
	public static void main(String[] args) {
		
		if(args.length<2) return;
		String readFile = args[0]; // Run As > configuration 에 arguments 넣어줌
		String writeFile = args[1];
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
//			fis = new FileInputStream("min.jpg");
//			fos = new FileOutputStream("min2.jpg");
//			fis = new FileInputStream("text.txt");  //파일에서 byte단위의 데이터 읽어오기
//			fos = new FileOutputStream("text2.txt");  //파일에 byte단위의 데이터 생성 후 저장

			fis = new FileInputStream(readFile); // 기반 스트림
			fos = new FileOutputStream(writeFile);
			bis = new BufferedInputStream(fis); // 보조 스트림
			bos = new BufferedOutputStream(fos);
			
			byte[] buff = new byte[1024];
			int len;
//			int data;

//			while((data=fis.read())!= -1) { 
//				fos.write(data); // min2에 min1을 넣어줌 
//			}
			while((len = bis.read(buff)) > 0) { 
				bos.write(buff, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bis != null) bis.close(); // 보조스트림을 close하면 기반 스트림을 close함.
				if(bos != null) bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
