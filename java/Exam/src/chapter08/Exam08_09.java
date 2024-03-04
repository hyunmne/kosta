package chapter08;


// 다음과 같은 조건의 예외 클래스를 작성하고 테스트 하시오.

class UnsupportedFuctionException extends RuntimeException {
	final private int ERR_CODE;
	
	public UnsupportedFuctionException() {
		ERR_CODE = 100;
	}

	public UnsupportedFuctionException(String str, int errCode) {
		super(str);
		this.ERR_CODE = errCode;
	}
	
	public int getErrorCode() {
		return ERR_CODE;
	}
	
	@Override
	public String getMessage() {
		return "["+getErrorCode()+"]"+super.getMessage();
	}
}

class Exam08_09 {
	public static void main(String[] args) throws Exception
	{
		try {
			throw new UnsupportedFuctionException("지원하지 않는 기능입니다.",100);
		} catch (UnsupportedFuctionException e) {
			System.out.println(e.getMessage());
		}
	}
}
