package com.test04;

abstract class Plane {
	String planeName;
	int fuelSize;
	
	public String getPlaneName() {
		return planeName;
	}

	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}

	public int getFuelSize() {
		return fuelSize;
	}

	public void setFuelSize(int fuelSize) {
		this.fuelSize = fuelSize;
	}

	Plane(){}
	
	Plane(String planeName, int fuelSize){
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}
	
	int refule(int fuel) {
		this.fuelSize = getFuelSize()+fuel;
		return fuelSize;
	}
	
	abstract void flight(int distance);
}
