package dao;

import java.util.List;

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

	@Override
	public List<Board> selectBrdList(Integer row) throws Exception {
		return sqlSession.selectList("mapper.board.selectBrdList", row);
	}

	@Override
	public Integer selectBrdCnt() throws Exception {
		return sqlSession.selectOne("mapper.board.selectBrdCnt");
	}

	@Override
	public Board selectBrd(Integer num) throws Exception {
		return sqlSession.selectOne("mapper.board.selectBrd", num);
	}

	@Override
	public void updateBoard(Board board) throws Exception {
		sqlSession.update("mapper.board.updateBoard", board);
		sqlSession.commit();
	}

}
