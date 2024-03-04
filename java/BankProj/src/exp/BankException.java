package exp;

public class BankException extends Exception {
	private BankError errCode;
	public BankException(BankError errCode, String msg) {
		super(msg);
		this.errCode = errCode;
	}
	public BankException(BankError errCode) {
		this.errCode = errCode;
	}
	
	@Override
	public String toString() {
		String errMessage = getMessage();
		errMessage = errMessage!=null? ":":"";
		
		switch(errCode) {
		case NO_ID: errMessage += "error! 계좌번호가 틀립니다"; break;
		case DOUBLE_ID: errMessage += "error! 계좌번호가 증복됩니다."; break;
		case DEPOSIT: errMessage += "error! 입금액 오류입니다."; break;
		case OVERDRAWN: errMessage += "error! 잔액이 부족합니다."; break;
		case MENU: errMessage += "error! 메뉴 선택 오류입니다."; break;
		case NO_SENDID: errMessage += "error! 보내는 계좌번호가 틀립니다."; break;
		case NO_RECVID: errMessage += "error! 받는 계좌 번호가 틀립니다."; break;
		}
		
		return errMessage;
	}
}
