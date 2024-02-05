
public class Account {
	
	String id;
	String name;
	int balance;
	public String money;
	
	Account() {}
	
	Account(String id, String name){
		this.id = id;
		this.name = name;
	}
	
	Account(String id, String name, int balance){
		this(id, name);
		this.balance = balance;
	}
	
	void deposit(int money) {
		if(money > 0) balance += money;
	}
	
	void withdraw(int money) {
		if(money <= balance) balance -= money;
	}
	
	String info() {
//		return "계좌번호:" + id + ", 이름:" + name + ", 잔액:" + balance; 
		return String.format("계좌번호:%s, 이름:%s, 잔액:%d", id, name, balance); 
	}
	
	public static void main(String[] args) {
		Account acc1 = new Account();
		acc1.id = "1002";
		acc1.name = "김길동";
		acc1.balance = 200000;
		Account acc2 = new Account("1001", "홍길동", 100000);
		Account acc3 = new Account("1003", "강길동");
		
		System.out.println(acc1.info());
		acc1.deposit(10000);
		System.out.println(acc1.info());
		acc1.withdraw(5000);
		System.out.println(acc1.info());
	}
}
//계좌번호:1002, 이름:김길동, 잔액:200000
//계좌번호:1002, 이름:김길동, 잔액:210000
//계좌번호:1002, 이름:김길동, 잔액:205000