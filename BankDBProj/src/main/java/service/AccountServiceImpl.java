package service;

import dao.AccountDAO;
import dao.AccountDAOImpl;
import dto.Account;

public class AccountServiceImpl implements AccountService {

	private AccountDAO accDAO = new AccountDAOImpl();
	
	@Override
	public void makeAccount(Account acc) throws Exception {
		
		Account sacc = accDAO.selectAccount(acc.getId()); // select로 계좌 정보 확인
		if (sacc!=null) throw new Exception("계좌번호가 중복됩니다."); // 중복 계좌 예외처리
		
		accDAO.insertAccount(acc); // DB에 계좌 추가
	}

}
