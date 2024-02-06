
public class StarMain {
	public static void main(String[] args) {
		Tank tank = new Tank();
		Marine marine = new Marine();
		SCV scv = new SCV();
		
		
		scv.repair(tank);
//		scv.repair(marine);	//error
		scv.repair(scv); 
	}
}
