package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.MybatisSqlSessionFactory;
import vo.Location;

public class LocationDaoImpl implements LocationDao {
	private SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	@Override
	public void insertLocation(Location loc) throws Exception {
		sqlSession.insert("mapper.location.insertLocation", loc);
		sqlSession.commit();
	}

	@Override
	public List<Location> selectLocList(Integer row) throws Exception {
		return sqlSession.selectList("mapper.location.selectLocList", row);
	}

	@Override
	public Integer selectLocCnt() throws Exception {
		return sqlSession.selectOne("mapper.location.selectLocCnt");
	}

}
