package dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import util.MybatisSqlSessionFactory;

public class BoardLikeDaoImpl implements BoardLikeDao {
	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	@Override
	public void insertBrdLike(String memberId, Integer boardNum) throws Exception {
		Map<String,Object> param = new HashMap<>();
		param.put("memberId", memberId);
		param.put("boardNum", boardNum);
		sqlSession.insert("mapper.boardlike.insertBrdLike", param);
		sqlSession.commit();
	}

	@Override
	public void deleteBrdLike(String memberId, Integer boardNum) throws Exception {
		Map<String,Object> param = new HashMap<>();
		param.put("memberId", memberId);
		param.put("boardNum", boardNum);
		sqlSession.delete("mapper.boardlike.deleteBrdLike", param);
		sqlSession.commit();
	}

	@Override
	public Integer selectBrdLike(String memberId, Integer boardNum) throws Exception {
		Map<String,Object> param = new HashMap<>();
		param.put("memberId", memberId);
		param.put("boardNum", boardNum);
		return sqlSession.selectOne("mapper.boardlike.selectBrdLike", param);
	}


}
