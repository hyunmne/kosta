package com.test05;

public class Sales extends Employee implements Bonus {

	Sales(){}
	
	Sales(String name, int num, String dept, int sal){
		super(name, num, dept, sal);
	}
	
	@Override
	double tax() {
		return (getSal()*0.13);
	}

	@Override
	public void incentive(int pay) {
		setSal(getSal()+(int)(pay*1.2));
		
	}

}
