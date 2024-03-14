package dao;

import java.util.List;

import dto.Account;

public interface AccountDAO {  //DB관련
	void insertAccount(Account acc) throws Exception;
	List<Account> selectAccList() throws Exception;
	Account selectAccount(String id) throws Exception;
	void updateAccount(Account acc) throws Exception;
}