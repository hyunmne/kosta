package dao;

import org.apache.ibatis.session.SqlSession;

import dto.UserInfo;
import util.MybatisSqlSessionFactory;

public class UserInfoDaoImpl implements UserInfoDao {
	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	@Override
	public UserInfo selectUserInfo(Long id) throws Exception {
		return sqlSession.selectOne("mapper.userInfo.selectUserInfo", id);
	}

	@Override
	public void insertUserInfo(UserInfo user) throws Exception {
		sqlSession.insert("mapper.userInfo.insertUserInfo", user);
		sqlSession.commit();
	}

}
