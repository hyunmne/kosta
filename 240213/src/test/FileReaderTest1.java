package test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class FileReaderTest1 {
	public static void main(String[] args) {
		FileReader fis = null;
		FileWriter fw = null;
		
		try {
			fis = new FileReader("news.txt");
			fw = new FileWriter("news-copy.txt");
			
			// 배열을 사용해서 파일 복사
			char[] buff = new char[128]; // 배열 생성 
			int len; // 현재 읽은 데이터의 길이
			while((len=fis.read(buff))!=-1) { // read() 메소드는 데이터의 길이를 반환
				fw.write(buff,0,len);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis!=null) fis.close();
				if(fw!=null) fw.close();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}
}
