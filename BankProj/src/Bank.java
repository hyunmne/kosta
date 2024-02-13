import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import emp.Account;
import emp.SpecialAccount;
import exp.BankError;
import exp.BankException;

public class Bank {

	Scanner sc = new Scanner(System.in);
	Map<String, Account> accs = new HashMap<>();  //TreeMap으로 해도 됨

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

		//key값(id)으로 중복체크
		if(accs.containsKey(id)) {  //중복이면 true
			throw new BankException(BankError.DOUBLE_ID);
		}
		//HashMap에 key값과 value값 넣기
		accs.put(id, new SpecialAccount(id, name, money, grade));  
	}

	void makeAccount() throws BankException {
		System.out.println("\n[일반계좌개설]");
		System.out.print("계좌번호: ");
		String id = sc.next();
		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("입금액: ");
		int money = sc.nextInt();

		//key값(id)으로 중복체크
		if(accs.containsKey(id)) {  //중복이면 true
			throw new BankException(BankError.DOUBLE_ID);
		}
		//HashMap에 key값과 value값 넣기
		accs.put(id, new Account(id, name, money));
	}

	void deposit() throws BankException {
		System.out.println("\n[입금]");
		System.out.print("계좌를 입력하세요: ");
		String id = sc.next();

		System.out.print("금액을 입력하세요: ");
		int money = sc.nextInt();

		//key값(id)이 없으면 해당 예외 발생
		if(accs.containsKey(id) == false) { 
			throw new BankException(BankError.NO_ID);
		}
		//HashMap key값의 value값 money 수정
		accs.get(id).deposit(money);

	}

	void withdraw() throws BankException {
		System.out.println("\n[출금]");
		System.out.print("계좌를 입력하세요: ");
		String id = sc.next();

		System.out.print("출금액: ");
		int money = sc.nextInt();

		//key값(id)이 없으면 해당 예외 발생
		if(accs.containsKey(id) == false) { 
			throw new BankException(BankError.NO_ID);
		}
		//HashMap key값의 value값 money 수정
		accs.get(id).withdraw(money);
	}

	void accountInfo() throws BankException {
		System.out.println("\n[계좌조회]");
		System.out.print("계좌번호: ");
		String id = sc.next();

		//key값(id)이 없으면 해당 예외 발생
		if(accs.containsKey(id) == false) { 
			throw new BankException(BankError.NO_ID);
		}

		System.out.println(accs.get(id).info());
	}

	void allAccountInfo() {
		System.out.println("\n[전체계좌조회]");

		//HashMap(accs)에 들어온 모든 값들 만큼 반복문 돌기
		//      for(Account acc : accs.values()) {
		//         System.out.println(acc.info());
		//      }

		Iterator<Account> it = accs.values().iterator();
		while (it.hasNext()) {
			System.out.println(it.next().info());
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

		if(accs.containsKey(sendId) == false) {
			throw new BankException(BankError.NO_SENDID);
		} 
		if(accs.containsKey(recvId) == false) {
			throw new BankException(BankError.NO_SENDID);
		} 

		accs.get(sendId).withdraw(money);
		accs.get(recvId).withdraw(money);
	}

	public void storeAccs() {  //계좌목록 파일로 저장
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("accs.bin");
			dos = new DataOutputStream(fos);

			dos.writeInt(accs.size());  //1.계좌의 개수 저장
			for(Account acc : accs.values()) {  //계좌목록만 가져오기
				if(acc instanceof SpecialAccount) {
					dos.writeChar('S');  //2.특수계좌 구분자
					dos.writeUTF(((SpecialAccount)acc).getGrade());  //3.등급
				} else {
					dos.writeChar('N');  //일반계좌 구분자
				}
				dos.writeUTF(acc.getId());  //4.계좌번호
				dos.writeUTF(acc.getName());  //5.이름
				dos.writeInt(acc.getBalance());  //6.잔액
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dos != null) {
					dos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void loadAccs() {  //계좌목록 파일로부터 읽어오기
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("accs.bin");
			dis = new DataInputStream(fis);

			//1.계좌갯수 읽어오기
			int size = dis.readInt();
			char accSect;
			String id;
			String name;
			String grade = null;
			int balance;

			for(int i = 0; i < size; i++) {
				//2.계좌구분 읽어오기(S or N)
				accSect = dis.readChar();
				if(accSect == 'S') {
					grade = dis.readUTF();  //3.특수계좌일 경우 등급
				}
				id = dis.readUTF();  //4.계좌번호
				name = dis.readUTF();  //5.이름
				balance = dis.readInt();  //6.잔액

				if(accSect == 'N') {
					accs.put(id, new Account(id, name, balance));
				} else {
					accs.put(id, new SpecialAccount(id, name, balance, grade));
				}
			}

		} catch (IOException e) {
			//         e.printStackTrace();  //개설된 계좌가 없으면 파일이 생성되지 않았기 때문에 해당 예외가 발생하므로 화면에 문구가 안 뜨도록 주석
		} finally {
			try {
				if(dis != null) {
					dis.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void storeAccs_txt() {
		// FileWriter, BufferedWriter, accs.txt
		// 1001,홍길동,100000
		// 1002,김길동,200000,VIP

		// 1. FileWriter, BufferedWriter 선언과 초기화
		BufferedWriter bw = null;
		try {
			// 2. 파일명으로 FileWrtier 생성 > 생략
			// 3. 생성된 FileWriter로 BufferedWriter 생성
			bw = new BufferedWriter(new FileWriter("accs.txt"));

			for (Account acc : accs.values()) {
				String str = acc.getId();
				// 4. 계좌의 목록에서 각 계좌를 가져와 각 항목을 , 구분자로 이어 하나의 문자열로 만들기
				str += ","+acc.getName();
				str += ","+acc.getBalance();
				if (acc instanceof SpecialAccount) {
					str += ","+((SpecialAccount)acc).getGrade();
				}
				// 5. br를 이용하여 저장
				bw.write(str);
				// 6. 라인바꾸기 : br.newLine()
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 7. 예외처리 및 br close
			try {
				if(bw!=null) bw.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void loadAccs_txt() {
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("accs.txt"));
			String str = null;
			while((str=br.readLine())!=null) {
				String[] arr = str.split(",");
				String id = arr[0];
				String name = arr[1];
				int balance = Integer.parseInt(arr[2]);

				if(arr.length==4) { // 특수 계좌
					String grade = arr[3];
					accs.put(id, new SpecialAccount(id, name, balance, grade));
				} else {
					accs.put(id, new Account(id,name,balance));
				}
			}
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try {
				if (br!=null) br.close();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.loadAccs_txt();
		System.out.println("~~~ 어서오세요 ~~~");
		while(true) {
			try {
				int sel = bank.menu();
				if(sel == 0) {
					bank.storeAccs_txt();
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