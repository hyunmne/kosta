package test;

// 16진법을 2진수로,...???
// cafe
// 1100101011111110

public class ArrayExam {
	public static void main(String[] args) {
//		char[] hex = {'c', 'a', 'f', 'e'}; //329dfc
		char[] hex = {'3', '2', '9', 'D', 'E', 'F'}; //329dfc
		String[] binary = { "0000", "0001", "0010", "0011",
							"0100", "0101", "0110", "0111",
							"1000", "1001", "1010", "1011",
							"1100", "1101", "1110", "1111"};
		String result = "";
		
		for(int i=0; i<hex.length; i++) {
			if(hex[i]>='0' && hex[i]<='9') { // 숫자 형태 char일 경우에
				result += binary[hex[i]-'0']; // char를 숫자로 바꾸고 바꾼 값을 result에 넣음 
			} else if(hex[i]>='A' && hex[i]<='Z'){ // 대문자일 경우에
				result += binary[hex[i]-'A'+10];
			} else { // 소문자일 경우에
				result += binary[hex[i]-'a'+10];
			}
		}
		
		System.out.println(result);
	}
}
