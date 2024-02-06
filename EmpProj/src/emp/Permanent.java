package emp;

public class Permanent extends Employee {
	int salary;
	public Permanent() {}
	public Permanent(String id, String name, int salary) {
		super(id,name);
		this.salary=salary;
	}
	@Override
	public String toString() {
		return super.toString()+", 급여 : "+getPay();
	}
	public int getPay() {
		return salary;
	}
}
