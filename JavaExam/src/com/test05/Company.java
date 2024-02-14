package com.test05;

import java.util.HashMap;

public class Company {
	public static void main(String[] args) {
		Bonus bonus;
		HashMap<Integer, Employee> map = new HashMap<>();
		Employee e1 = new Secretary("홍길동", 1,"Secretary", 800);
		Employee e2 = new Sales("이순신", 2,"Sales", 1200);
			
		// 1번의 데이터를 기반으로 객체를 생성하여 HashMap에 저장한다. 
		// HashMap에 저장시 키 값은 각 객체의 Number로 한다. 
		map.put(e1.getNum(), e1);
		map.put(e2.getNum(), e2);
		
		// 모든 객체의 기본 정보를 출력한다. ( for문 이용 , keySet() 이용 ) 
		System.out.println("  name     department     salary");
		System.out.println("------------------------------------");
		for (int num : map.keySet()) {
			Employee value = map.get(num);
			System.out.println("  "+value.name+"     "+value.dept+"     "+value.sal);
		}
		
		System.out.println("\n인센티브100지급\n");
		System.out.println("  name     department     salary   tax");
		System.out.println("---------------------------------------");
		
		// 모든 객체의 인센티브 100씩 지급한다. 
		e1.incentive(100);
		e2.incentive(100);
		
		// 모든 객체의 정보와 세금을 출력한다. ( for문 이용 
		for (int num : map.keySet()) {
			Employee value = map.get(num);
//			System.out.println("  "+value.name+"     "+value.dept
//					+"     "+value.sal+"     "+value.tax());
			System.out.printf("   %s      %s     %d     %.2f \n", value.name, value.dept, value.sal, value.tax());
		}
	}
}
