package dao;

import dto.Employee;

public interface EmployeeDao {
	int insertEmp(Employee emp) throws Exception;
	Employee selectEmp(String empNo, String empPw) throws Exception;
}
