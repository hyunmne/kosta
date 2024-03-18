package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dto.Facility;
import util.MybatisSqlSessionFactory;

public class FacilityDaoImpl implements FacilityDao {
	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();

	@Override
	public List<Facility> selectFacList() throws Exception {
		return sqlSession.selectList("mapper.facility.selectFacList");
	}

	@Override
	public Facility selectFacility(String id) throws Exception {
		return sqlSession.selectOne("mapper.facility.selectFacility", id);
	}

	@Override
	public void updateFacility(String id, String name, Integer price, String etc) throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("id", id);
		param.put("name", name);
		param.put("price", price);
		param.put("etc", etc);
		
		sqlSession.update("mapper.facility.updateFacility", param);
		sqlSession.commit();
	}



}
