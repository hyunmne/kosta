package dao;

import org.apache.ibatis.session.SqlSession;

import dto.Employee;
import util.MybatisSqlSessionFactory;

public class EmployeeDaoImpl implements EmployeeDao {
	private SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();

	@Override
	public int insertEmp(Employee emp) throws Exception {
		int cnt = sqlSession.insert("mapper.employee.insertEmp", emp);
		sqlSession.commit();
		return cnt;
	}

	@Override
	public Employee selectEmp(String empNo, String empPw) throws Exception {
		 return sqlSession.selectOne("mapper.employee.selectEmp", empNo);
	}

}
