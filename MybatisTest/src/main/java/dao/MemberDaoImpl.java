package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.Member;
import util.MybatisSqlSessionFactory;

public class MemberDaoImpl implements MemberDao {
	private SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();

	@Override
	public void insertMember(Member mem) throws Exception {
		sqlSession.insert("mapper.member.insertMember", mem);
		sqlSession.commit();
	}

	@Override
	public Member selectMember(String id) throws Exception {
		return sqlSession.selectOne("mapper.member.selectMember", id);
	}
}
