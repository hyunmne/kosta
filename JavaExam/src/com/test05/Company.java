package com.test05;

import java.util.HashMap;

public class Company {
	public static void main(String[] args) {
		HashMap<Integer, Employee> map = new HashMap<>();
			
		// 1번의 데이터를 기반으로 객체를 생성하여 HashMap에 저장한다. 
		// HashMap에 저장시 키 값은 각 객체의 Number로 한다. 
		map.put(1, new Secretary("홍길동", 1,"Secretary", 800));
		map.put(2, new Sales("이순신", 2,"Sales", 1200));
		
		// 모든 객체의 기본 정보를 출력한다. ( for문 이용 , keySet() 이용 ) 
		System.out.println("  name     department     salary");
		System.out.println("------------------------------------");
		for (Integer num : map.keySet()) {
			Employee value = map.get(num);
			System.out.printf("  %s %15s %10s\n", value.getName(), value.getDept(), value.getSal());
		}
		
		System.out.println("\n인센티브100지급\n");
		System.out.println("  name     department     salary      tax");
		System.out.println("----------------------------------------------");
		
		for (Employee emp : map.values()) {
			
			// Secreatry와 Sales는 Bonus의 자식이기 때문에..? 
			if (emp instanceof Bonus) {
				((Bonus)emp).incentive(100);
			}
			
//			if (emp instanceof Secretary) {
//				((Secretary)emp).incentive(100);
//			} else if (emp instanceof Sales) {
//				((Sales)emp).incentive(100);
//			}
		}
		
		// 모든 객체의 정보와 세금을 출력한다. ( for문 이용 
		for (int num : map.keySet()) {
			Employee value = map.get(num);
			System.out.printf("  %s %15s %10s  %8.2f\n", value.getName(), value.getDept(), value.getSal(), value.tax());
		}
	}
}
