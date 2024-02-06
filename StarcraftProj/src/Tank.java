
public class Tank extends GroundUnit implements IRepairable{
	public Tank() {
		super(150);
		hitPoint = MAX_HP;
	}
	
	@Override
	public String toString() {
		return "TANK";
	}

}
