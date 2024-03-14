package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.Account;
import util.MybatisSqlSessionFactory;

public class AccountDAOImpl implements AccountDAO {
	private SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	@Override
	public void insertAccount(Account acc) throws Exception {
		sqlSession.insert("mapper.account.insertAccount", acc);
		sqlSession.commit();
	}

	@Override
	public List<Account> selectAccList() throws Exception {
		return sqlSession.selectList("mapper.account.selectAccList");
	}

	@Override
	public Account selectAccount(String id) throws Exception {
		return sqlSession.selectOne("mapper.account.selectAccount", id);
	}

	@Override
	public void updateAccount(Account acc) throws Exception {
		sqlSession.update("mapper.account.updateAccount", acc);
		sqlSession.commit();
	}

}