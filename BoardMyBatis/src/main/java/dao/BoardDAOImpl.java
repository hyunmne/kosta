package dao;

import org.apache.ibatis.session.SqlSession;

import dto.Board;
import util.MybatisSqlSessionFactory;

public class BoardDAOImpl implements BoardDAO {
	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	@Override
	public void insertDAO(Board board) throws Exception {
		sqlSession.insert("mapper.board.insertBoard", board); // mapper에서 id와 parameterType
		sqlSession.commit();
	}

}
