package dao;

import java.sql.Connection;
import java.util.List;

import dto.Account;

public interface AccountDAO {  //DB관련
	void insertAccount(Account acc) throws Exception;
	Account selectAccount(String id) throws Exception;
	void updateAccountBalance(String id, int balance) throws Exception;
	boolean updateAccountBalanceTransaction(Connection conn, String id, int balance) throws Exception;
	List<Account> selectAccountList() throws Exception;
}