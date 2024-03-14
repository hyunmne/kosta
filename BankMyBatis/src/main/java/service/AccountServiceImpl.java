package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.AccountDAO;
import dao.AccountDAOImpl;
import dto.Account;

public class AccountServiceImpl implements AccountService {

	private AccountDAO accDao = new AccountDAOImpl();

	@Override
	public void makeAccount(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int balance = Integer.parseInt(request.getParameter("balance"));
		String type = request.getParameter("type");
		String grade = request.getParameter("grade");
		
		Account acc = new Account(id, name, balance, type, grade);
		accDao.insertAccount(acc);
	}

	@Override
	public void allAccountInfo(HttpServletRequest request) throws Exception {
		List<Account> accList = accDao.selectAccList();
		request.setAttribute("accList", accList);
	}

	@Override
	public Account accInfo(String id) throws Exception {
		return accDao.selectAccount(id);
	}

	@Override
	public void deposit(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");
		int money = Integer.parseInt(request.getParameter("money"));
		
		Account acc = accDao.selectAccount(id);
		acc.deposit(money);
		request.setAttribute("acc", acc);
		accDao.updateAccount(acc);
	}

	@Override
	public void withdraw(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");
		int money = Integer.parseInt(request.getParameter("money"));
		
		Account acc = accDao.selectAccount(id);
		acc.withdraw(money);
		request.setAttribute("acc", acc);
		accDao.updateAccount(acc);
	}

	@Override
	public void transfer(HttpServletRequest request) throws Exception {
		String sAcc = request.getParameter("sendAcc");
		String rAcc = request.getParameter("recAcc");
		int money = Integer.parseInt(request.getParameter("money"));
		
		Account sendAcc = accDao.selectAccount(sAcc);
		Account recAcc = accDao.selectAccount(rAcc);
		
		sendAcc.withdraw(money);
		recAcc.deposit(money);
		
		request.setAttribute("acc", sendAcc);
		accDao.updateAccount(recAcc);
		accDao.updateAccount(sendAcc);
	}


}