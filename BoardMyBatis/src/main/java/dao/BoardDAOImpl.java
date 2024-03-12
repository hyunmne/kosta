package dao;

import org.apache.ibatis.session.SqlSession;

import dto.Board;
import dto.File;
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

	@Override
	public void insertFile(File file) throws Exception {
		sqlSession.insert("mapper.board.insertFile", file);
		sqlSession.commit();
	}

}
