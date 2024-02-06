package chapter04;


//숫자로 이루어진 문자열 str이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코
//드를 완성하라. 만일 문자열이 "12345"라면, ‘1+2+3+4+5’의 결과인 15를 출력이 출력되어야 한다. 
//(1)에 알맞은 코드를 넣으시오.

public class Homework04_09 {
	public static void main(String[] args) {
		
		String str = "12345";
		int sum = 0;
		
		for (int i = 0; i < str.length(); i++) {
            // 현재 자리의 문자를 가져옴
            char charStr = str.charAt(i);

            // 문자를 숫자로 변환하여 더함
            int intStr = charStr - '0';

            // 더한 값을 누적
            sum += intStr;
        }

        System.out.println("sum=" + sum);
	}
}
