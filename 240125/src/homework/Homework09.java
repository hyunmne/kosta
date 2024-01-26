package homework;

// 주어진 배열을 시계 방향으로 90도 회전시켜서 출력하는 프로그램을 완성하시오.

//**                // (0,0) => (0,3)    // (2,0) => (0,1)
//**                // (0,1) => (1,3)    // (2,1) => (1,1)
//*****             // (0,2) => (2,3)    // (2,2) => (2,1)
//*****             // (0,3) => (3,3)    // (2,3) => (3,1)
                    // (0,4) => (4,3)    // (2,4) => (4,1)
//****                               
//****              // (1,0) => (0,2)
//**                // (1,1) => (1,2)
//**                // (1,2) => (2,2)
//**                // (1,3) => (3,2)
                    // (1,4) => (4,2)

public class Homework09 {
	public static void main(String[] args) {
		char[][] star = { {'*','*',' ',' ',' '},
						  {'*','*',' ',' ',' '},
						  {'*','*','*','*','*'},
						  {'*','*','*','*','*'}};
		
		char[][] result = new char[star[0].length][star.length];
		
//		**   
//		**   
//		*****
//		*****
		for(int i=0; i < star.length;i++) {
			for(int j=0; j < star[i].length;j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
		 
		// 90도 회전
		for(int i=0; i < star.length;i++) {
			for(int j=0; j < star[i].length;j++) {
				// result[i]가 star[j]가 되어야 함.
				result[j][3-i] = star[i][j];
			}
		}
		
		for(int i=0; i < result.length;i++) {
			for(int j=0; j < result[i].length;j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}
}
