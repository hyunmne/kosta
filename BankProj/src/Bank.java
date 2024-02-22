import java.util.List;
import java.util.Scanner;

import acc.Account;
import acc.SpecialAccount;
import dao.AccountDAO;
import exp.BankError;
import exp.BankException;

public class Bank {

	Scanner sc = new Scanner(System.in);
	AccountDAO dao = new AccountDAO();

	int menu() throws BankException {
		System.out.println("\n[코스타 은행]");
		System.out.println("0.종료");
		System.out.println("1.계좌개설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.계좌조회");
		System.out.println("5.전체계좌조회");
		System.out.println("6.계좌이체");
		System.out.print("선택>> ");
		int sel = Integer.parseInt(sc.next());
		if(sel < 0 || sel > 6) {
			throw new BankException(BankError.MENU);
		}
		return sel;
	}

	void selMenu() throws BankException {
		System.out.println("\n[계좌개설]");
		System.out.println("1.일반계좌");
		System.out.println("2.특수계좌");
		System.out.print("선택>> ");
		int sel = Integer.parseInt(sc.next());
		switch(sel) {
		case 1: makeAccount(); break;
		case 2: makeSpecialAccount(); break;
		default: throw new BankException(BankError.MENU);
		}
	}

	void makeSpecialAccount() throws BankException {
		System.out.println("\n[특수계좌개설]");
		System.out.print("계좌번호: ");
		String id = sc.next();
		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("입금액: ");
		int money = sc.nextInt();
		System.out.print("등급(VIP, Gold, Silver, Normal): ");
		String grade = sc.next();

		// 계좌 중복 체크 
		Account acc = dao.selectAccount(id);
		if(acc!=null) throw new BankException(BankError.DOUBLE_ID);

		boolean success = dao.insertAccount(new SpecialAccount(id, name, money, grade));
		if(success) {
			System.out.println("계좌가 개설되었습니다.");
		} else {
			System.out.println("계좌가 개설되지 않았습니다.");
		}
	}

	void makeAccount() throws BankException {
		System.out.println("\n[일반계좌개설]");
		System.out.print("계좌번호: ");
		String id = sc.next();
		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("입금액: ");
		int money = sc.nextInt();

		// 계좌 중복 체크 
		Account acc = dao.selectAccount(id);
		if(acc!=null) throw new BankException(BankError.DOUBLE_ID);

		boolean success = dao.insertAccount(new Account(id, name, money));
		if(success) {
			System.out.println("계좌가 개설되었습니다.");
		} else {
			System.out.println("계좌가 개설되지 않았습니다.");
		}
	}

	
	void deposit() throws BankException {
		System.out.println("\n[입금]");
		System.out.print("계좌를 입력하세요: ");
		String id = sc.next();
		System.out.print("금액을 입력하세요: ");
		int money = Integer.parseInt(sc.nextLine());
		Account acc = dao.selectAccount(id);
		// 계좌 번호 존재 유무 확인
		if(acc==null) throw new BankException(BankError.NO_ID);
		// 가져온 계좌에 입금 처리
		acc.deposit(money);
		// DB에 입금한 금액으로 수정
		dao.updateAccount(acc);
	}

	void withdraw() throws BankException {
		System.out.println("\n[출금]");
		System.out.print("계좌를 입력하세요: ");
		String id = sc.next();
		System.out.print("출금액: ");
		int money = Integer.parseInt(sc.nextLine());
		Account acc = dao.selectAccount(id);
		// 계좌번호 체크
		if(acc==null) throw new BankException(BankError.NO_ID);
		// 가져온 계좌에 출금 처리
		acc.withdraw(money);
		// DB에 출금한 금액으로 수정
		dao.updateAccount(acc);
	}

	void accountInfo() throws BankException {
		System.out.println("\n[계좌조회]");
		System.out.print("계좌번호: ");
		String id = sc.next();

		Account acc = dao.selectAccount(id);
		if(acc==null) throw new BankException(BankError.NO_ID);
		System.out.println(acc);
	}

	void allAccountInfo() {
		System.out.println("\n[전체계좌조회]");
		List<Account> accList = dao.selectAccountList();
		for (Account acc : accList) {
			System.out.println(acc);
		}
	}

	void transfer() throws BankException {
		System.out.println("\n[계좌이체]");
		System.out.print("보내는 계좌번호: ");
		String sendId = sc.next();
		System.out.print("받는 계좌번호: ");
		String recvId = sc.next();
		System.out.print("이체금액: ");
		int money = sc.nextInt();
		dao.transferAccount(sendId, recvId, money);

	}
	
	


	public static void main(String[] args) {
		Bank bank = new Bank();
		System.out.println("~~~ 어서오세요 ~~~");
		while(true) {
			try {
				int sel = bank.menu();
				if(sel == 0) {
					break;
				}
				switch(sel) {
				case 1: bank.selMenu(); break;
				case 2: bank.deposit(); break;
				case 3: bank.withdraw(); break;
				case 4: bank.accountInfo(); break;
				case 5: bank.allAccountInfo(); break;
				case 6: bank.transfer(); break;
				}
			} catch (NumberFormatException e) {
				System.out.println("입력 형식이 바르지 않습니다.");
			} catch (BankException e) {
				System.out.println(e);
			}
		}
	}
}