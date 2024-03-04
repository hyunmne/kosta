package test;

public class ForTest3 {
	public static void main(String[] args) {

		//*****
		//*****
		//*****
		//*****
		//*****
		for (int k=1; k<=5; k++) {
			for (int i=1; i<=5; i++) {
				System.out.print("*");
			}
			System.out.println();
		}


		//*
		//**
		//***
		//****
		//*****
		for (int i=0; i<=5; i++) {
			for (int k=0; k<i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}

		//*****
		//****
		//***
		//**
		//*
		for (int i=0; i<=5; i++) {
			for (int k=5; k>i; k--) {
				System.out.print("*");
			}
			System.out.println();
		}


		//     	   	  *
		//           ***
		//          *****
		//         *******
		//        *********
		//       ***********
		//      *************
		//     ***************
		//    *****************
		
		int cnt = 7;
		
		for (int i=0; i<=cnt; i++) { // 8줄 생성 (0-7) 
			
			for (int k=1; k<=cnt-i; k++) {
				System.out.print(" "); // 공백 출력
			}

			for (int j=0; j<2*i+1; j++) {
				System.out.print("*"); 
			}
			
			System.out.println();
		}
		
		
		
	}
}
