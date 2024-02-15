package com.test05;

class Secretary extends Employee implements Bonus {
	Bonus b;
	
	@Override
	double tax() {
		return getSal()*0.1;
	}
	
	Secretary(){}
	
	Secretary(String name, int num, String dept, int sal){
		super(name, num, dept, sal);
	}

	@Override
	public void incentive(int pay) {
		setSal(getSal()+(int)(pay*0.8));
	}

}
