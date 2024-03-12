package dao;

import org.apache.ibatis.session.SqlSession;

import dto.Board;
import util.MybatisSqlSessionFactory;

public class BoardDAOImpl implements BoardDAO {
	// sql session 생성
	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	@Override
	public void insertDAO(Board board) throws Exception {
		// mapper에서 id와 parameterType
		sqlSession.insert("mapper.board.insertBoard", board);
		
		sqlSession.commit();
	}

}
