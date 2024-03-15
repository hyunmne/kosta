package service;

import dto.Employee;

public interface EmpService {
	void singUp(Employee emp) throws Exception;
	void login(String empNo, String empPw) throws Exception;
}
