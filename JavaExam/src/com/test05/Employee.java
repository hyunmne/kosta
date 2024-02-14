package com.test05;

abstract class Employee implements Bonus{
	String name;
	int num;
	String dept;
	int sal;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	Employee() {}
	
	Employee(String name, int num, String dept, int sal){
		this.name = name;
		this.num = num;
		this.dept = dept;
		this.sal = sal;
	}
	
	abstract double tax();

}
