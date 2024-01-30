package test;

class Account {
	String id, name;
	int balance;
	
	String info() {
		return "계좌번호 :" + id + ", 이름 :" +name+", 잔액 :" +balance;
	}
	
	void deposit(int money) {
		balance += money;
	}
	
	void withdraw(int money) {
		balance -= money;
	}
	
}

public class ClassTest02 {
	public static void main(String[] args) {
		Account acc = new Account();
		acc.id = "10001";
		acc.name = "홍길동";
		acc.balance = 100000;
		System.out.println(acc.info());
		
		acc.deposit(10000);
		System.out.println(acc.info());
		
		acc.withdraw(5000);
		System.out.println(acc.info());
	}
}

// 계좌번호 : 10001, 이름 : 홍길동, 잔액 : 100000
// 계좌번호 : 10001, 이름 : 홍길동, 잔액 : 110000
