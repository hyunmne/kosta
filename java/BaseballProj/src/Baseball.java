import service.BaseballService;

public class Baseball {
	public static void main(String[] args) {
		BaseballService service = new BaseballService();
		while(true) {
			service.start();
		}
	}
}
