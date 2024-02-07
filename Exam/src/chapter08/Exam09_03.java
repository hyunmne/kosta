package chapter08;

public class Exam09_03 {
	public static void main(String[] args) {
		String fullPath = "c:\\jdk1.5\\work\\PathSeparateTest.java";
		String path = "";
		String fileName = "";
		/*
		(1) 알맞은 코드를 넣어 완성하시오.
		 */
		
		path = fullPath.substring(0,14);
		fileName = fullPath.substring(15);
		
		System.out.println("fullPath:"+fullPath);
		System.out.println("path:"+path);
		System.out.println("fileName:"+fileName);
	}
}
