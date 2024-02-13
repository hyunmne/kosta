package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Vector;

public class SequenceStreamTest2 {
	public static void main(String[] args) {
		SequenceInputStream sis = null;
		FileOutputStream fos = null;
		// 세 개 이상의 file을 하나의 file로 관리하기 위해 sequence를 사용한다. 
		try {
			Vector<InputStream> list = new Vector<>();
			list.add(new FileInputStream("pubao1.txt"));
			list.add(new FileInputStream("pubao2.txt"));
			list.add(new FileInputStream("pubao3.txt"));
			
			sis = new SequenceInputStream(list.elements());
			fos = new FileOutputStream("pubao.txt");
			byte[] buff = new byte[1024];
			int len;
			while ((len=sis.read(buff))>0) {
				fos.write(buff,0,len);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(sis!=null) sis.close();
				if(fos!=null) fos.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
