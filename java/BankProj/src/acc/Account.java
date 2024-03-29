package acc;

import java.io.Serializable;

import exp.BankError;
import exp.BankException;

public class Account implements Serializable {
	
	String id;
	String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int balance;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String money;
	
	public Account() {}
	
	public Account(String id, String name){
		this.id = id;
		this.name = name;
	}
	
	public Account(String id, String name, int balance){
		this(id, name);
		this.balance = balance;
	}
	
	public void transDeposit(int money) throws BankException {
		if (money <=0) throw new BankException(BankError.DEPOSIT);
		balance += money;
	}
	
	public void deposit(int money) throws BankException {
		if(money<=0) throw new BankException(BankError.DEPOSIT);
		balance += money;
	}
	
	public void withdraw(int money) throws BankException {
		if(money <= balance) balance -= money;
	}
	
	public String toString() {
//		return "계좌번호:" + id + ", 이름:" + name + ", 잔액:" + balance; 
		return String.format("계좌번호:%s, 이름:%s, 잔액:%d", id, name, balance); 
	}
	
	public static void main(String[] args) throws BankException {
		Account acc1 = new Account();
		acc1.id = "1002";
		acc1.name = "김길동";
		acc1.balance = 200000;
		Account acc2 = new Account("1001", "홍길동", 100000);
		Account acc3 = new Account("1003", "강길동");
		
		System.out.println(acc1.toString());
		acc1.deposit(10000);
		System.out.println(acc1.toString());
		acc1.withdraw(5000);
		System.out.println(acc1.toString());
	}
}
//계좌번호:1002, 이름:김길동, 잔액:200000
//계좌번호:1002, 이름:김길동, 잔액:210000
//계좌번호:1002, 이름:김길동, 잔액:205000