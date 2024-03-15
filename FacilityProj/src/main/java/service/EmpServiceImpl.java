package service;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import dto.Employee;

public class EmpServiceImpl implements EmpService {
	
	private EmployeeDao empDao;
	public EmpServiceImpl() {
		this.empDao = new EmployeeDaoImpl();
	}

	@Override
	public void singUp(Employee emp) throws Exception {
		int cnt = empDao.insertEmp(emp);
		if(cnt<=0); throw new Exception("회원가입 오류");
	}

	@Override
	public void login(String empNo, String empPw) throws Exception {
		Employee emp = empDao.selectEmp(empNo, empPw);
		if (emp == null) throw new Exception("아이디가 틀립니다."); // mem이 비어있으면 회원정보 존재 ㄴㄴ 
		if (!emp.getPw().equals(empPw)) throw new Exception("비밀번호가 틀렸습니다.");
	}

}
