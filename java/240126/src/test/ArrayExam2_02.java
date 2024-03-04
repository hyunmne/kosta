package test;

import java.util.Scanner;

// 영문 대문자를 입력받다가 대문자 이외의 문자가 입력되면 입력을 중단하고
// 영문 대문자들에 대하여 1번 이상 입력된 각 문자와 그 문자의 개수를 사전 순으로 출력하는 프로그램
// 입력되는 문자의 개수는 2개 이상 100개 이하이다. 

// 입력                  	  // 출력    
// A B C F F F B Z !      // A : 1 
                          // B : 2 
                          // C : 1 
                          // F : 3 
                          // Z : 1 

public class ArrayExam2_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] count = new int[26];
		int ch;
		
		while(true) {
			ch = sc.next().charAt(0);
			if (!(ch>= 'A' && ch<= 'Z')) break;
			count[ch-'A']++;
		}
		
		for (int i=0; i<count.length; i++) {
			if(count[i]!=0) {
				System.out.println(
						String.format("%c : %d", (char)('A'+i), count[i]));
			}
		}
		
	}
}
