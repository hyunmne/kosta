package service;

import javax.servlet.http.HttpServletRequest;

import dto.Account;


public interface AccountService {
   void makeAccount(HttpServletRequest request) throws Exception;
   void allAccountInfo(HttpServletRequest request) throws Exception;
   Account accInfo(String id) throws Exception;
   void deposit(HttpServletRequest request) throws Exception;
   void withdraw(HttpServletRequest request) throws Exception;
   void transfer(HttpServletRequest request) throws Exception;
}