package test;

import java.util.Scanner;

//6개의 문자배열을 만들고 {'J', 'O', 'U', 'G', 'O', 'L'}으로 초기화 한 후
//문자 한 개를 입력 받아 배열에서의 위치를 출력하는 프로그램 작성
//첫번째 위치는 0번이며 배열에 없는 문자가 입력되면 "none"라는 메시지를 출력하고 끝내는 프로그램을 작성

public class ArrayExam06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 배열 초기
		char[] carr = {'J', 'O', 'U', 'G', 'O', 'L'};
		// char 타입으로 형변환 해서 입력 받아줌
		char ch = sc.nextLine().charAt(0);
		// for문 밖에서도 i를 사용하려고 따로 빼서 적어줌
		int i=0;
		
		// i를 밖에서 선언해줬으니 선언문 생략
		for (; i<carr.length; i++) {
			if (ch == carr[i]) break;
		}
		
		// i가 배열 길이와 똑같으면 같은 글자가 없다는 뜻이기에 none 출력
		if (i==carr.length) System.out.println("none");
		else System.out.println(i);
	}
}
