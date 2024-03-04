package BankProj;

public class Account {
	
	String id, name;
	int balance;
	
	String info() {
//		return id+", "+name+", "+balance;
		return String.format("계좌번호:%s, 이름:%s, 잔액:%d", id, name, balance);
	}
	
	Account() {}
	
	Account(String id, String name, int balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	
	Account(String id, String name) {
		this(id, name, 0);
	}
	
	
	void deposit (int money) {
		if (money > 0) balance += money;
	}
	
	void withdraw (int money) {
		if (balance >= money) balance -= money;
	}
	
	public static void main(String[] args) {
		Account acc1 = new Account();
		acc1.id="1002";
		acc1.name="김길동";
		acc1.balance=200000;
		
		Account acc2 = new Account("1001", "홍길동", 100000);
		Account acc3 = new Account("1003", "강길동");
		
		System.out.println(acc1.info());
		acc1.deposit(10000);
		System.out.println(acc1.info());
		acc1.withdraw(5000);
		System.out.println(acc1.info());
	}
}
