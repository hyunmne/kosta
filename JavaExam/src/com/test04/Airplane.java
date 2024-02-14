package com.test04;

class Airplane extends Plane {

	public Airplane(String planeName, int fuelSize) {
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}

	@Override
	void flight(int distance) {
		this.fuelSize = this.fuelSize / 10; // 100
		distance = (distance / 10)*3; // 30
		
		fuelSize = (fuelSize - distance)*10;
	}
}
