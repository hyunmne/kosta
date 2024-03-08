package service;

import java.util.List;

import dto.Account;

public interface AccountService {
   void makeAccount(Account acc) throws Exception;
   Account accountInfo(String id) throws Exception;
   
   void deposit(String id, int balance) throws Exception;
   void withdraw(String id, int balance) throws Exception;
   void transfer(String sid, String rid, int money) throws Exception;
   List<Account> allAccountInfo() throws Exception;
   
   boolean checkDoubleId(String id) throws Exception;
}