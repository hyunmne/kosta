package test;

public class ForTest3 {
	public static void main(String[] args) {

		//*****
		//*****
		//*****
		//*****
		//*****
//		for (int k=1; k<=5; k++) {
//			for (int i=1; i<=5; i++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		
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
	}
}
