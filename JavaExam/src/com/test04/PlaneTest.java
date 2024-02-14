package com.test04;

public class PlaneTest {
	public static void main(String[] args) {
		// Airplane과 Cargoplane 객체생성
		Airplane ap1 = new Airplane("L777", 1000);
		Cargoplane cp1 = new Cargoplane("C50", 1000);
		
		// 생성된 객체의 정보 출력
		System.out.println("  Plane     fuelSize");
		System.out.println("=======================");
		System.out.println("  "+ap1.planeName+"      "+ap1.fuelSize);
		System.out.println("  "+cp1.planeName+"       "+cp1.fuelSize);
		
		// Airplane과 Cargoplane 객체에 100씩 운항
		System.out.println("  100 운항\n");
		ap1.flight(100);
		cp1.flight(100);
		
		// 운항후 객체의 변경된 정보 출력
		System.out.println("  Plane     fuelSize");
		System.out.println("=======================");
		System.out.println("  "+ap1.planeName+"      "+ap1.getFuelSize());
		System.out.println("  "+cp1.planeName+"       "+cp1.fuelSize);
		System.out.println("  200 주유\n");
		
		// Airplane과 Cargoplane 객체에 200씩 주유
		ap1.refule(200);
		cp1.refule(200);
		
		// 주유후 객체의 변경된 정보 출력
		System.out.println("  Plane     fuelSize");
		System.out.println("=======================");
		System.out.println("  "+ap1.planeName+"      "+ap1.fuelSize);
		System.out.println("  "+cp1.planeName+"       "+cp1.fuelSize);
	}
}
