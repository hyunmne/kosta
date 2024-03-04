package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

public class SequenceStreamTest1 {
	public static void main(String[] args) {
		FileInputStream fis1 = null;
		FileInputStream fis2 = null;
		SequenceInputStream sis = null;
		FileOutputStream fos = null;
		
		try {
			fis1 = new FileInputStream("min.jpg");
			fis2 = new FileInputStream("mini.jpg");
			sis = new SequenceInputStream(fis1, fis2);
			fos = new FileOutputStream("totmin.jpg");
			
			byte[] buff = new byte[1024];
			int len;
			while ((len=sis.read(buff))>0) {
				fos.write(buff, 0, len);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(sis!=null) sis.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
