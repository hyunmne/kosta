package BankProj;


//Special Account 
//	1. Account의 모든 속성과 기능을 가지고 있음
//	2. 등급에 따라 입금시마다 입금액의 특정 퍼센트만큼 입금을 추가해줌
//    grade : VIP(4%) Gold(3%) Silver(2%) Normal(1%)
    


public class SpecialAccount extends Account {
	
	String grade;
	
	public SpecialAccount(String id, String name, int balance, String grade) {
		super(id,name,balance);
		this.grade = grade;
	}
	
	@Override
	String info() {
		return super.info()+", 등급:" +grade;
	}
	
	@Override
	void deposit(int money) {
		double rate = 0;
		switch(grade.toUpperCase()) {
		case "VIP": rate=0.04; break;
		case "GOLD": rate=0.03; break;
		case "SILVER": rate=0.02; break;
		case "NORMAL": rate=0.01; break;
		}
		super.deposit(money+(int)(money*rate));
	}

	public static void main(String[] args) {
		SpecialAccount sacc = new SpecialAccount("1001", "홍길동", 100000, "vip");
		System.out.println(sacc.info());
		sacc.deposit(10000);
		System.out.println(sacc.info());
		sacc.withdraw(5000);
		System.out.println(sacc.info());
		
	}
}

// 계좌번호 : 1001, 이름:홍길동, 잔액:100000, 등급:VIP
// 계좌번호 : 1001, 이름:홍길동, 잔액:110400, 등급:VIP
// 계좌번호 : 1001, 이름:홍길동, 잔액:105400, 등급:VIP
