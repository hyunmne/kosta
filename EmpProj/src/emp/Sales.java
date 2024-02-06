package emp;

public class Sales extends Permanent implements IBusinessTrip {
	int bonus;
	public Sales() {}
	public Sales(String id,String name, int salary, int bouns) {
		super(id,name,salary);
		this.bonus=bouns;
	}
	@Override
	public int getPay() {
		return super.getPay()+bonus;
	}
	@Override
	public void goBusinessTrip(int day) {
		bonus += day * 100000;
	}
}
