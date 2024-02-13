package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest1 {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null; // 라인 단위로 읽어올 수 있음.
		try {
			fr = new FileReader("news.txt");
			br = new BufferedReader(fr);
			
			String str = null;
			while((str=br.readLine())!=null) { // Line을 전체 다 읽어옴 
				System.out.println(str);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br!=null) br.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
