package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.Board;
import dto.BFile;
import util.MybatisSqlSessionFactory;

public class BoardDaoImpl implements BoardDao {
	private SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();

	@Override
	public List<Board> selectBrdList(Integer row) throws Exception {
		return sqlSession.selectList("mapper.board.selectBrdList", row);
	}

	@Override
	public Integer selectBrdCnt() throws Exception {
		return sqlSession.selectOne("mapper.board.selectBrdCnt");
	}

	@Override
	public Board selectBoard(Integer num) throws Exception {
		return sqlSession.selectOne("mapper.board.selectBoard", num);
	}

	@Override
	public void insertBoard(Board board) throws Exception {
		sqlSession.insert("mapper.board.insertBoard", board);
		sqlSession.commit();
	}

	@Override
	public void insertFile(BFile file) throws Exception {
		sqlSession.insert("mapper.board.insertFile", file);
		sqlSession.commit();
	}

	@Override
	public void updateBoard(Board board) throws Exception {
		sqlSession.update("mapper.board.updateBoard", board);
		sqlSession.commit();
	}

	@Override
	public void updateBrdViewCnt(Integer num) throws Exception {
		sqlSession.update("mapper.board.updateBrdViewCnt", num);
		sqlSession.commit();
	}
	
	
}
