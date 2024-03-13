package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.Board;
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
	
	
}
