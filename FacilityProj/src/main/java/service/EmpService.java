package service;

import dto.Employee;

public interface EmpService {
	void singUp(Employee emp) throws Exception;
	Employee login(String empNo, String empPw) throws Exception;
}
