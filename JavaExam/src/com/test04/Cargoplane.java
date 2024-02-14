package com.test04;

class Cargoplane extends Plane {

	public Cargoplane(String planeName, int fuelSize) {
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}

	@Override
	void flight(int distance) {
		this.fuelSize = this.fuelSize / 10;
		distance = (distance / 10)*5;
		
		fuelSize = (fuelSize - distance)*10;
	}
}
