package BankProj;

import java.util.Scanner;

public class Bank {
	Scanner sc = new Scanner(System.in);
	Account[] accs = new Account[100]; // 배열 초기화
	int cnt; // 계좌의 갯수 초기화
	
	int menu() {
		System.out.println("[코스타 은행]");
		System.out.println("0. 종료");
		System.out.println("1. 계좌 개설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 계좌 조회");
		System.out.println("5. 전체 계좌 조회");
		System.out.print("선택 >> ");
		return sc.nextInt();
	}
	
	void makeAccount() {
		System.out.println("[계좌 개설]");
		System.out.print("계좌 번호 : ");
		String id = sc.next();
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("입금액 : ");
		int money = sc.nextInt();
		// 1. Account 객체 만들기
		// 2. 생성된 객체를 accs에 담기
		accs[cnt++] = new Account(id, name, money);
		
		System.out.println(name+"님, 계좌 생성이 완료되었습니다.");
		System.out.println("[생성 계좌 정보]");
		System.out.println(String.format("계좌 번호 : %s, 이름 : %s, 입금액 : %d", id, name, money));
		System.out.println();
	}
	
	void deposit() {
		System.out.println("[입금]");
		System.out.print("입금하실 계좌번호를 입력해주세요. ");
		String id = sc.next();
		System.out.print("입금하실 금액을 입력해주세요. ");
		int money = sc.nextInt();
		
		for (int i=0; i<accs.length; i++) {
			if (accs[i].id.equals(id)) {
				accs[i].balance += money;
				System.out.println(accs[i].name + "님 계좌에 "+money +"원 입금이 완료 되었습니다.");
				System.out.println();
				return;
			}
		}
	}
	void withdraw() {
		System.out.println("[출금]");
		System.out.print("출금하실 계좌번호를 입력해주세요. ");
		String id = sc.next();
		
		System.out.print("출금할 금액을 입력해주세요. ");
		int money = sc.nextInt();
		
		for (int i=0; i<accs.length; i++) {
			if (accs[i].id.equals(id)) {
				accs[i].balance -= money;
				System.out.println(accs[i].name + "님 계좌에 "+money +"원 출금이 완료 되었습니다.");
				System.out.println();
				return;
			}
		}
	}
	void accountInfo() {
		System.out.println("[계좌 조회]");
		System.out.print("계좌 번호 : ");
		String id = sc.next();
		// 1. accs에서 id에 해당하는 Account를 찾는다.
		// 2. 찾은 계좌의 정보를 출력한다.
		
		for (int i=0; i<accs.length; i++) {
			if (accs[i].id.equals(id)) {
				System.out.println(accs[i].name+"님의 계좌 정보");
				System.out.println(String.format("계좌 번호 : %s, 이름 : %s, 잔액 : %d", accs[i].id, accs[i].name, accs[i].balance));
				System.out.println();
				return;
			}
		}
	}
	
	void allAccountInfo() {
		System.out.println("[전체 계좌 조회]");
		for (int i=0; i<accs.length; i++) {
			System.out.println(String.format("계좌 번호 : %s, 이름 : %s, 잔액 : %d", accs[i].id, accs[i].name, accs[i].balance));
			System.out.println();
			return;
		}
	}
	
	public static void main(String[] args) {
		Bank bank = new Bank();
		while(true) {
			int sel = bank.menu();
			if(sel==0) break;
			switch(sel) {
			case 1: bank.makeAccount(); break;
			case 2: bank.deposit(); break;
			case 3: bank.withdraw(); break;
			case 4: bank.accountInfo(); break;
			case 5: bank.allAccountInfo(); break;
			}
		}
	}
	
}
