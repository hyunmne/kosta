
public class SCV extends GroundUnit implements IRepairable {
	public SCV() {
		super(60);
		hitPoint = MAX_HP;
	}
	@Override
	public String toString() {
		return "SCV";
	}
	
	public void repair(IRepairable unit) {
		if(unit instanceof Unit) {
			Unit runit = (Unit)unit;
			runit.hitPoint = runit.MAX_HP;
		}
	}
}
